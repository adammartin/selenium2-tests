package com.pillar.pages;

import org.joda.time.DateTime;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByCssSelector;

public class BasePage {

  private final WebDriver driver;
  private final FindsByCssSelector cssSelector;
  private final JavascriptExecutor executor;
  private final int maxWait;

  public BasePage(final WebDriver driver, final FindsByCssSelector cssSelector, final JavascriptExecutor executor, final int maxWaitInSeconds) {
    this.driver = driver;
    this.cssSelector = cssSelector;
    this.executor = executor;
    maxWait = maxWaitInSeconds * 1000;
  }

  protected final WebDriver driver() {
    return driver;
  }
  
  protected final FindsByCssSelector cssSelector() {
    return cssSelector;
  }
  
  protected final JavascriptExecutor javascriptExecutor() {
    return executor;
  }

  protected final int maxWait() {
    return maxWait;
  }

  protected final void closeBrowser() {
    driver.close();
  }

  protected final WebElement findElement(final String css) {
    waitForAjaxToComplete();
    final WebElement element = cssSelector.findElementByCssSelector(css);
    waitForAjaxToComplete();
    return element;
  }

  protected final WebElement findElementWithWait(final String css) {
    WebElement element = null;
    final long end = System.currentTimeMillis() + maxWait;
    while (System.currentTimeMillis() < end) {
      element = cssSelector.findElementByCssSelector(css);
      if (element.isDisplayed()) {
        break;
      }
    }
    return element;
  }

  protected final void clickLink(final String linkCssSelector) {
    findElement(linkCssSelector).click();
    waitForAjaxToComplete();
  }

  protected final void clickLinkWithWait(final String linkCssSelector) {
    findElementWithWait(linkCssSelector).click();
    waitForAjaxToComplete();
  }

  protected final void submit(final String input, final String inputCssSelector) {
    final WebElement inputElement = findElement(inputCssSelector);
    inputElement.clear();
    inputElement.sendKeys(input);
    inputElement.submit();
    waitForAjaxToComplete();
  }

  protected final boolean elementIsValid(final String elementCssSelector) {
    try {
      final WebElement element = findElement(elementCssSelector);
      waitForAjaxToComplete();
      return element.isDisplayed();
    } catch (final NoSuchElementException ex) {
      return false;
    }
  }

  protected final boolean textOnPage(final String text) {
    return driver.getPageSource().contains(text);
  }

  private final void waitForAjaxToComplete() {
    long result = jQueryActive();
    final DateTime maxWaitTime = new DateTime().plusMillis(maxWait);
    while (result != 0 && !maxWaitTime.isAfterNow()) {
      result = jQueryActive();
    }
  }

  private Long jQueryActive() {
    return (Long) executor.executeScript("return jQuery.active;");
  }
}
