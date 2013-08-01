package com.pillar.pages;

import static org.openqa.selenium.By.name;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByCssSelector;

public class AuthenticationPage extends BasePage {
  private static final String PASSWORD = "j_password";
  private static final String USER_ID = "j_username";
  private static final String INCORRECT_PAGE = "This is not the login page: ";
  public static String PAGE_TITLE = "Login";

  public AuthenticationPage(final WebDriver driver, final FindsByCssSelector cssSelector, final JavascriptExecutor executor, final int maxWaitInSeconds) {
    super(driver, cssSelector, executor, maxWaitInSeconds);
    if (!PAGE_TITLE.equals(driver.getTitle())) {
      throw new IllegalStateException(INCORRECT_PAGE + driver.getTitle());
    }
  }

  public final HomePage authenticate(final String userName, final String password) {
    final WebElement passWordField = enterCredentials(userName, password);
    passWordField.submit();
    return new HomePage(driver(), cssSelector(), javascriptExecutor(), maxWait());
  }

  private final WebElement enterCredentials(final String userName, final String password) {
    driver().findElement(name(USER_ID)).sendKeys(userName);
    final WebElement passWordField = driver().findElement(name(PASSWORD));
    passWordField.sendKeys(password);
    return passWordField;
  }
}
