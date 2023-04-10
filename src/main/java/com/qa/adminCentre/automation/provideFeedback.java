package com.qa.adminCentre.automation;

import com.microsoft.playwright.*;

public class provideFeedback {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext bcx1 = browser.newContext();

        Page page = bcx1.newPage();

        page.navigate("https://qa.one.redhat.com/admin-center/");
        page.locator("a.pf-c-nav__link").nth(2).click();
	}

}
