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
    final ModernWebDriver driver = new ModernWebDriverFactory().webDriver(bundle);
    if (Boolean.TRUE.toString().equalsIgnoreCase(getProperty(AUTHENTICATION_REQUIRED))) {
      return authenticateHomePage(driver, maxWait);
    }
    return new HomePage(driver, maxWait, bundle.getProperty(APPLICATION_URL));
  }

  private HomePage authenticateHomePage(final ModernWebDriver driver, final int maxWait) {
    final AuthenticationPage authPage = new AuthenticationPage(driver, maxWait, bundle);
    return authPage.authenticate(getProperty(USER_GROUP), getProperty(PASSWORD));
  }

  private String getProperty(final String propertyName) {
    return bundle.getProperty(propertyName);
  }
}
