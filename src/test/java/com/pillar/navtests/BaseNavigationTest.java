package com.pillar.navtests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.pillar.driver.HomePageFactory;
import com.pillar.pages.HomePage;

public class BaseNavigationTest {
  private static HomePage homePage;

  protected HomePage homePage() {
    return homePage;
  }

  @BeforeClass
  public final static void setUpClass() {
    homePage = HomePageFactory.loadHomePage();
  }

  @AfterClass
  public final static void tearDownClass() {
    homePage.close();
  }

  @Before
  public final void setUp() {
    homePage.returnToHomePage();
  }
}
