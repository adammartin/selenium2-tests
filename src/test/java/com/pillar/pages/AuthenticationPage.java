package com.pillar.pages;

import static org.openqa.selenium.By.name;

import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.pillar.driver.ModernWebDriver;

public class AuthenticationPage extends BasePage {
  public static String PAGE_TITLE = "Login";
  private static final String PASSWORD = "selenium.auth.element.name.password";
  private static final String USER_ID = "selenium.auth.element.name.user";
  private static final String INCORRECT_PAGE = "This is not the login page: ";

  private final Properties bundle;

  public AuthenticationPage(final ModernWebDriver driver, final int maxWaitInSeconds, final Properties bundle) {
    super(driver, maxWaitInSeconds);
    this.bundle = bundle;
    if (!PAGE_TITLE.equals(driver.getTitle())) {
      throw new IllegalStateException(INCORRECT_PAGE + driver.getTitle());
    }
  }

  public final HomePage authenticate(final String userName, final String password) {
    final WebElement passWordField = enterCredentials(userName, password);
    passWordField.submit();
    return new HomePage(driver(), maxWait());
  }

  private final WebElement enterCredentials(final String userName, final String password) {
    driver().findElement(name(bundle.getProperty(USER_ID))).sendKeys(userName);
    final WebElement passWordField = driver().findElement(name(bundle.getProperty(PASSWORD)));
    passWordField.sendKeys(password);
    return passWordField;
  }
}
