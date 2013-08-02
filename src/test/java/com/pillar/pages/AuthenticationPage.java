package com.pillar.pages;

import static org.openqa.selenium.By.name;

import org.openqa.selenium.WebElement;

import com.pillar.driver.ModernWebDriver;

public class AuthenticationPage extends BasePage {
  private static final String PASSWORD = "j_password";
  private static final String USER_ID = "j_username";
  private static final String INCORRECT_PAGE = "This is not the login page: ";
  public static String PAGE_TITLE = "Login";

  public AuthenticationPage(final ModernWebDriver driver, final int maxWaitInSeconds) {
    super(driver, maxWaitInSeconds);
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
    driver().findElement(name(USER_ID)).sendKeys(userName);
    final WebElement passWordField = driver().findElement(name(PASSWORD));
    passWordField.sendKeys(password);
    return passWordField;
  }
}
