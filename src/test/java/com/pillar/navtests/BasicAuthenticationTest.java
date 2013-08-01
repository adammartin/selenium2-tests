package com.pillar.navtests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import com.pillar.pages.HomePage;

public class BasicAuthenticationTest extends BaseNavigationTest {

	@Test
	public void canAuthenticate() {
		homePage();
		assertThat(homePage().title(), is(HomePage.HOME_PAGE_TITLE));
	}

}
