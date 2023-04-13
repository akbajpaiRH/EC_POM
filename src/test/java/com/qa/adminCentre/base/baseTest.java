package com.qa.adminCentre.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.adminCentre.factory.PlaywrightFactory;
import com.qa.adminCentre.pages.HomePage;

public class baseTest {
	
	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	protected HomePage homePage;
	
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		prop = pf.initProp();
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
