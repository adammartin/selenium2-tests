package com.pillar.pages;

import static org.openqa.selenium.By.name;

import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.pillar.driver.ModernWebDriver;

public class AuthenticationPage extends BasePage {
  private static final String PAGE_TITLE = "selenium.auth.element.page.title";
  private static final String PASSWORD = "selenium.auth.element.name.password";
  private static final String USER_ID = "selenium.auth.element.name.user";
  private static final String INCORRECT_PAGE = "This is not the login page: ";

  private final Properties bundle;

  public AuthenticationPage(final ModernWebDriver driver, final int maxWaitInSeconds, final Properties bundle) {
    super(driver, maxWaitInSeconds);
    this.bundle = bundle;
    final String pageTitle = bundle.getProperty(PAGE_TITLE);
    if (pageTitle != null && !pageTitle.equals(driver.getTitle())) {
      throw new IllegalStateException(INCORRECT_PAGE + driver.getTitle());
    }
  }

  public final HomePage authenticate(final String userName, final String password) {
    enterCredentials(userName, password).submit();
    return new HomePage(driver(), maxWait());
  }

  private final WebElement enterCredentials(final String userName, final String password) {
    final WebElement passWordField = driver().findElement(name(bundle.getProperty(PASSWORD)));
    driver().findElement(name(bundle.getProperty(USER_ID))).sendKeys(userName);
    passWordField.sendKeys(password);
    return passWordField;
  }
}
