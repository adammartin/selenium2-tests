package com.pillar.pages;

import com.pillar.driver.ModernWebDriver;

public class AttendeePage extends BasePage {

  public AttendeePage(ModernWebDriver driver, int maxWaitInSeconds) {
    super(driver, maxWaitInSeconds);
  }

  public String getTitle() {
    return driver().getTitle();
  }

}
