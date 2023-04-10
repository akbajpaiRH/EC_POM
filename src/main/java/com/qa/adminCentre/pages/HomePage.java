package com.qa.adminCentre.pages;

import com.microsoft.playwright.*;
public class HomePage {
	private Page page;
	private String search = "input.pf-c-search-input__text-input";
	private String header = "//h1[@data-ouia-component-type='PF4/Text']";
	
	public HomePage(Page page){
		this.page=page;
	}
	public String getHomeTitle() {
		String title = page.title();
		System.out.println("Page Title: "+title);
		return title;
	}
	public String getHomeURL() {
		String url = page.url();
		System.out.println("Page URL: "+url);
		return url;
	}
	public String doSearch(String query) {
		page.locator(search).click();
		page.fill(search, query);
		page.locator(search).press("Enter");
		String pageHeader = page.textContent(header);
		System.out.println("Page Header: "+pageHeader);
		return pageHeader;
	}
}
