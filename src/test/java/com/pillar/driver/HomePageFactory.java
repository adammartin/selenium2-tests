package com.pillar.driver;

import static com.pillar.driver.PropertyLoader.*;
import static java.lang.Integer.parseInt;

import java.util.Properties;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.pillar.pages.AuthenticationPage;
import com.pillar.pages.HomePage;

public class HomePageFactory {
  private Properties bundle;
  
  public HomePageFactory(final Properties bundle) {
    this.bundle = bundle;
  }

  public final HomePage loadHomePage() {
    final ModernWebDriver driver = webDriver();
    final int maxWait = parseInt(getProperty(MAX_WAIT));
    if (Boolean.TRUE.toString().equalsIgnoreCase(getProperty(AUTHENTICATION_REQUIRED))) {
      final AuthenticationPage authPage = new AuthenticationPage(driver, maxWait);
      return authPage.authenticate(getProperty(USER_GROUP), getProperty(PASSWORD));
    }
    return new HomePage(driver, maxWait);
  }

  private ModernWebDriver webDriver() {
    final HtmlUnitDriver htmlDriver = new HtmlUnitDriver(true);
    htmlDriver.get(getProperty(APPLICATION_URL));
    return new ModernWebDriver(htmlDriver, htmlDriver, htmlDriver);
  }

  private String getProperty(final String propertyName) {
    return bundle.getProperty(propertyName);
  }
}
