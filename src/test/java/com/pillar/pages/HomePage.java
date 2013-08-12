package com.pillar.pages;

import com.pillar.driver.ModernWebDriver;

public class HomePage extends BasePage {

  public static final String HOME_PAGE_TITLE = "Welcome to BlueBox";
  private static final String HOMEPAGE_HEADER_LINK = "div#blueBoxLogo a";

  public HomePage(final ModernWebDriver driver, final int maxWaitInSeconds) {
    super(driver, maxWaitInSeconds);
  }

  public final void close() {
    closeBrowser();
  }

  public void returnToHomePage() {
    clickLink(HOMEPAGE_HEADER_LINK);
  }

  public final String title() {
    return driver().getTitle();
  }
}
