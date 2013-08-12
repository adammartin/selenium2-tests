package com.pillar.driver;

import static com.pillar.driver.PropertyLoader.*;
import static java.lang.Integer.parseInt;

import java.util.Properties;

import com.pillar.pages.AuthenticationPage;
import com.pillar.pages.HomePage;

public class HomePageFactory {
  private Properties bundle;
  
  public HomePageFactory(final Properties bundle) {
    this.bundle = bundle;
  }

  public final HomePage loadHomePage() {
    final int maxWait = parseInt(getProperty(MAX_WAIT));
    final ModernWebDriver driver = new ModernWebDriverFactory().webDriver(getProperty(DRIVER_TYPE), getProperty(APPLICATION_URL));
    if (Boolean.TRUE.toString().equalsIgnoreCase(getProperty(AUTHENTICATION_REQUIRED))) {
      final AuthenticationPage authPage = new AuthenticationPage(driver, maxWait);
      return authPage.authenticate(getProperty(USER_GROUP), getProperty(PASSWORD));
    }
    return new HomePage(driver, maxWait);
  }

  private String getProperty(final String propertyName) {
    return bundle.getProperty(propertyName);
  }
}
