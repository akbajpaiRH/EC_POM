package com.qa.adminCentre.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.Proxy;

public class PlaywrightFactory {
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	
	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("The browser name is: "+browserName);
		playwright = Playwright.create();
		switch(browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
					.setHeadless(false).setProxy(new Proxy("http://squid.corp.redhat.com:3128")));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
					.setHeadless(false).setProxy(new Proxy("http://squid.corp.redhat.com:3128")));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
					.setHeadless(false).setProxy(new Proxy("http://squid.corp.redhat.com:3128")));
			break;
		case "chrome":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome")
					.setHeadless(false).setProxy(new Proxy("http://squid.corp.redhat.com:3128")));
			break;
		default:
			System.out.println("Pass a correct browser name");
		}
		
		browserContext = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true));
		page = browserContext.newPage();
		page.navigate(prop.getProperty("url").trim());
		return page;
	}
	
	public Properties initProp() {
		try{
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
