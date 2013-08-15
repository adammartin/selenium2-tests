package com.pillar.driver;

import static com.pillar.driver.PropertyLoader.*;
import static java.lang.String.format;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ModernWebDriverFactory {

  private static final String CHROME_DRIVER = "chrome";
  private static final String FIREFOX_DRIVER = "firefox";
  private static final String HTMLUNIT_DRIVER = "htmlunit";

  private static final String CHROME_EXECUTABLE_PROPERTY = "webdriver.chrome.driver";
  private static final String FIREFOX_EXECUTABLE_PROPERTY = "webdriver.firefox.bin";
  
  private static final String INVALID_DRIVER_EXCEPTION_MESSAGE = "Invalid driverType supplied '%s', valid driver types are htmlunit, chrome, and firefox";

  public ModernWebDriver webDriver(Properties bundle) {
    final String applicationUrl = bundle.getProperty(APPLICATION_URL);
    final String driverType = bundle.getProperty(DRIVER_TYPE);
    switch(driverType) {
      case HTMLUNIT_DRIVER :
        return htmlUnitDriver(applicationUrl);
      case FIREFOX_DRIVER :
        return fireFoxDriver(bundle, applicationUrl);
      case CHROME_DRIVER :
        return chromeDriver(bundle);
      default: 
        throw new IllegalArgumentException(format(INVALID_DRIVER_EXCEPTION_MESSAGE, driverType));
    }
  }

  private ModernWebDriver chromeDriver(Properties bundle) {
    System.setProperty(CHROME_EXECUTABLE_PROPERTY, bundle.getProperty(DRIVER_LOCATION));
    RemoteWebDriver driver = new ChromeDriver();
    driver.get(bundle.getProperty(APPLICATION_URL));
    return new ModernWebDriver(driver, driver, driver);
  }

  private ModernWebDriver htmlUnitDriver(final String applicationUrl) {
    final HtmlUnitDriver htmlDriver = new HtmlUnitDriver(true);
    htmlDriver.get(applicationUrl);
    return new ModernWebDriver(htmlDriver, htmlDriver, htmlDriver);
  }

  private ModernWebDriver fireFoxDriver(Properties bundle, final String applicationUrl) {
    System.setProperty(FIREFOX_EXECUTABLE_PROPERTY, bundle.getProperty(DRIVER_LOCATION));
    final FirefoxDriver driver = new FirefoxDriver();
    driver.get(applicationUrl);
    return new ModernWebDriver(driver, driver, driver);
  }
}
