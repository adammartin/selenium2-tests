package com.pillar.pages;

import com.pillar.driver.ModernWebDriver;

public class HomePage extends BasePage {

  private static final String ATTENDEE_SELECTOR = "a[href*=\"attendee\"]";
  private final String address;

  public HomePage(final ModernWebDriver driver, final int maxWaitInSeconds, final String address) {
    super(driver, maxWaitInSeconds);
    this.address = address;
  }

  public final void close() {
    closeBrowser();
  }

  public void returnToHomePage() {
    this.driver().navigate().to(address);
  }

  public final String title() {
    return driver().getTitle();
  }
  
  public final AttendeePage navigateToAttendeePage() {
    clickLink(ATTENDEE_SELECTOR);
    return new AttendeePage(driver(), maxWait());
  }
}
