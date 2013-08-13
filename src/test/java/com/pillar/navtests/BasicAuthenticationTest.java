package com.pillar.navtests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BasicAuthenticationTest extends BaseNavigationTest {
  private static final String HOME_PAGE_TITLE = "Welcome to BlueBox";

  @Test
  public void canAuthenticate() {
    assertThat(homePage().title(), is(HOME_PAGE_TITLE));
  }

  @Test
  public void canReturnToPageAndAmStillAuthenticate() throws Exception {
    homePage().returnToHomePage();
    assertThat(homePage().title(), is(HOME_PAGE_TITLE));
  }
}
