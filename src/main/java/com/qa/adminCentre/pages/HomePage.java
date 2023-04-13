package com.qa.adminCentre.pages;

import com.microsoft.playwright.*;
public class HomePage {
	private Page page;
	private String search = "input.pf-c-search-input__text-input";
	private String header = "//h1[@data-ouia-component-type='PF4/Text']";
	private String feedback_btn = "a.pf-c-nav__link";
	private String rating = "form svg";
	private String feedback_inp = "//textarea";
	private String submit_btn = "//button[@class='pf-c-button pf-m-primary pf-m-progress']";
	private String feedback_alert = "//h4[@class='pf-c-alert__title']";
	
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
	public String giveFeedback(String feedback, String suggestion) {
		page.locator(feedback_btn).nth(2).click();
		page.locator(rating).nth(4).click();
		page.locator(feedback_inp).nth(0).click();
		page.locator(feedback_inp).nth(0).fill(feedback);
		page.locator(feedback_inp).nth(1).click();
		page.locator(feedback_inp).nth(1).fill(suggestion);
		page.locator(submit_btn).click();
		String res = page.locator(feedback_alert).textContent();
		System.out.println(res);
		return res;
	}
}
