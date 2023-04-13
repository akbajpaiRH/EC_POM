package com.qa.adminCentre.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.microsoft.playwright.*;
import com.qa.adminCentre.base.baseTest;
import com.qa.adminCentre.factory.PlaywrightFactory;
import com.qa.adminCentre.pages.HomePage;

public class HomePageTest extends baseTest{
	
	@Test
	public void titleTest() {
		String title = homePage.getHomeTitle();
		Assert.assertEquals(title, prop.getProperty("title"));
	}
	@Test
	public void urlTest() {
		String url = homePage.getHomeURL();
		Assert.assertEquals(url, prop.getProperty("url"));
	}
	
	@Test
	public void feedbackTest() {
		String res = homePage.giveFeedback("Feedback", "Suggestion");
		Assert.assertEquals(res, prop.getProperty("feedback"));
	}
	
	@Test
	public void searchTest() {
		String header = homePage.doSearch("Briefing");
		Assert.assertEquals(header, "All Assets");
	}
	
}
