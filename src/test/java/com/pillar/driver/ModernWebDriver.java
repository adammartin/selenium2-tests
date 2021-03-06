package com.pillar.driver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByCssSelector;
/**
 * ModernWebDriver is intended to be a simple facade to allow us to wrap a RemoteWebDriver as easily as
 * a headless web driver (like HtmlUnitDriver).  This provides a layer of abstraction so test writers
 * do not need to account for the various flavor of drivers.
 * 
 * @author adammartin
 *
 */
public class ModernWebDriver implements WebDriver, JavascriptExecutor, FindsByCssSelector {

  private final WebDriver driver;
  private final JavascriptExecutor executor;
  private final FindsByCssSelector selector;

  public ModernWebDriver(final WebDriver driver, final JavascriptExecutor executor, final FindsByCssSelector selector) {
    this.driver = driver;
    this.executor = executor;
    this.selector = selector;
  }

  @Override
  public WebElement findElementByCssSelector(String using) {
    return selector.findElementByCssSelector(using);
  }

  @Override
  public List<WebElement> findElementsByCssSelector(String using) {
    return selector.findElementsByCssSelector(using);
  }

  @Override
  public Object executeScript(String script, Object... args) {
    return executor.executeScript(script, args);
  }

  @Override
  public Object executeAsyncScript(String script, Object... args) {
    return executor.executeAsyncScript(script, args);
  }

  @Override
  public void get(String url) {
    driver.get(url);
  }

  @Override
  public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }

  @Override
  public String getTitle() {
    return driver.getTitle();
  }

  @Override
  public List<WebElement> findElements(By by) {
    return driver.findElements(by);
  }

  @Override
  public WebElement findElement(By by) {
    return driver.findElement(by);
  }

  @Override
  public String getPageSource() {
    return driver.getPageSource();
  }

  @Override
  public void close() {
    driver.close();
  }

  @Override
  public void quit() {
    driver.quit();
  }

  @Override
  public Set<String> getWindowHandles() {
    return driver.getWindowHandles();
  }

  @Override
  public String getWindowHandle() {
    return driver.getWindowHandle();
  }

  @Override
  public TargetLocator switchTo() {
    return driver.switchTo();
  }

  @Override
  public Navigation navigate() {
    return driver.navigate();
  }

  @Override
  public Options manage() {
    return driver.manage();
  }

}
