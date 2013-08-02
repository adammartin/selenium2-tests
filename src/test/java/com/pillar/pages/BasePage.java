package com.pillar.pages;

import org.joda.time.DateTime;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.pillar.driver.ModernWebDriver;

public class BasePage {

  private final ModernWebDriver driver;
  private final int maxWait;

  public BasePage(final ModernWebDriver driver, final int maxWaitInSeconds) {
    this.driver = driver;
    maxWait = maxWaitInSeconds * 1000;
  }

  protected final ModernWebDriver driver() {
    return driver;
  }
  
  protected final int maxWait() {
    return maxWait;
  }

  protected final void closeBrowser() {
    driver.close();
  }

  protected final WebElement findElement(final String css) {
    waitForAjaxToComplete();
    final WebElement element = driver.findElementByCssSelector(css);
    waitForAjaxToComplete();
    return element;
  }

  protected final WebElement findElementWithWait(final String css) {
    WebElement element = null;
    final long end = System.currentTimeMillis() + maxWait;
    while (System.currentTimeMillis() < end) {
      element = driver.findElementByCssSelector(css);
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
    return (Long) driver.executeScript("return jQuery.active;");
  }
}
