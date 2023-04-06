package com.qa.adminCentre.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.microsoft.playwright.*;
import com.qa.adminCentre.factory.PlaywrightFactory;
import com.qa.adminCentre.pages.HomePage;

public class HomePageTest {
	
	PlaywrightFactory pf;
	Page page;
	HomePage homePage;
	
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		page = pf.initBrowser("chromium");
		homePage = new HomePage(page);
	}
	
	@Test
	public void titleTest() {
		String title = homePage.getHomeTitle();
		Assert.assertEquals(title, "Admin Center");
	}
	@Test
	public void urlTest() {
		String url = homePage.getHomeURL();
		Assert.assertEquals(url, "https://qa.one.redhat.com/admin-center/");
	}
	
	@Test
	public void searchTest() {
		String header = homePage.doSearch("Briefing");
		Assert.assertEquals(header, "All Assets");
	}
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
