package com.pillar.driver;

import static java.lang.Integer.parseInt;

import java.util.Locale;
import java.util.ResourceBundle;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.pillar.pages.AuthenticationPage;
import com.pillar.pages.HomePage;

public class HomePageFactory {
  private static final String MAX_WAIT = "selenium.pageLoadWaitSeconds";
  private static final String PASSWORD = "selenium.auth.password";
  private static final String USER_GROUP = "selenium.auth.usergroup";
  private static final String AUTHENTICATION_REQUIRED = "selenium.auth.active";
  private static final String APPLICATION_URL = "selenium.application.url";
  private static final String PROPERTY_FILE_NAME = "selenium";
  private static ResourceBundle bundle;

  public final static HomePage loadHomePage() {
    final ModernWebDriver driver = webDriver();
    final int maxWait = parseInt(getProperty(MAX_WAIT));
    if (Boolean.TRUE.toString().equalsIgnoreCase(getProperty(AUTHENTICATION_REQUIRED))) {
      final AuthenticationPage authPage = new AuthenticationPage(driver, driver, driver, maxWait);
      return authPage.authenticate(getProperty(USER_GROUP), getProperty(PASSWORD));
    }
    return new HomePage(driver, driver, driver, maxWait);
  }

  private static ModernWebDriver webDriver() {
    final HtmlUnitDriver htmlDriver = new HtmlUnitDriver(true);
    htmlDriver.get(getProperty(APPLICATION_URL));
    return new ModernWebDriver(htmlDriver, htmlDriver, htmlDriver);
  }

  private static void loadPropertiesIfNotAlreadyLoaded() {
    if (bundle == null) {
      bundle = ResourceBundle.getBundle(PROPERTY_FILE_NAME, Locale.US);
    }
  }

  private static String getProperty(final String propertyName) {
    loadPropertiesIfNotAlreadyLoaded();
    return bundle.getString(propertyName);
  }
}
