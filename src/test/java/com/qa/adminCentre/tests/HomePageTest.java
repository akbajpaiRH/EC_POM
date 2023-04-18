package com.qa.adminCentre.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.adminCentre.base.baseTest;

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
