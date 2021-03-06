package com.pillar.navtests;

import static com.pillar.driver.PropertyLoader.DEFAULT_PROPERTY_FILE_NAME;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.pillar.driver.HomePageFactory;
import com.pillar.driver.PropertyLoader;
import com.pillar.pages.HomePage;

public class BaseNavigationTest {
  private static HomePage homePage;

  protected HomePage homePage() {
    return homePage;
  }

  @BeforeClass
  public final static void setUpClass() {
    homePage = new HomePageFactory(new PropertyLoader().loadProperties(DEFAULT_PROPERTY_FILE_NAME)).loadHomePage();
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
