package com.pillar.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.FindsByCssSelector;

public class HomePage extends BasePage {

	public static final String HOME_PAGE_TITLE = "Welcome to BlueBox";
	private static final String HOMEPAGE_HEADER_LINK = "div#blueBoxLogo a";

	public HomePage(final WebDriver driver, final FindsByCssSelector cssSelector, final JavascriptExecutor executor, final int maxWaitInSeconds) {
		super(driver, cssSelector, executor, maxWaitInSeconds);
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
