package com.testleaf.tests;

import java.util.Map;

import org.openqa.selenium.Keys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testleaf.constants.BrowserTestEngine;
import com.testleaf.constants.BrowserType;
import com.testleaf.constants.LocatorType;
import com.testleaf.drivers.manager.DriverManager;
import com.testleaf.web.api.APIClient;
import com.testleaf.web.api.ResponseAPI;
import com.testleaf.web.browser.Browser;
import com.testleaf.web.element.Button;
import com.testleaf.web.element.Edit;
import com.testleaf.web.element.Element;
import com.testleaf.web.element.Link;

public class TestRAWithHeaders {

	public static void main(String[] args) {
		
		Browser browser = DriverManager.getBrowserWithAPI(BrowserTestEngine.SELENIUM, BrowserType.CHROME);
		
		APIClient api = (APIClient) browser;
		
		String firstName = "Rahul4";
		String lastName = "Test944";
		String companyName = "TestLeaf1";
		
//		String body = "{\n"
//				+ "\"FirstName\": "+ firstName +",\n"
//				+ "\"LastName\": "+ lastName +",\n"
//				+ "\"Company\": "+ company +"\n"
//				+ "}";
		
		String body = "{\n"
                + "    \"FirstName\": \""+firstName+"\",\n"
                + "    \"LastName\": \""+lastName+"\",\n"
                + "    \"Company\": \""+ companyName+"\"\n"
                + "}";
		
		String endPoint = "https://qeagle8-dev-ed.develop.my.salesforce.com/services/data/v58.0/sobjects/Lead";
		
		ResponseAPI response = api.post(endPoint, body);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().toString());
		
		// load the url
		browser.navigateTo("https://login.salesforce.com/");

		// Find the user name and enter
		Edit username = browser.locateEdit(LocatorType.ID, "username");
		username.type("majay3574@gmail.com");

		// Find the password and enter
		Edit password = browser.locateEdit(LocatorType.ID, "password");
		password.type("Ajaymichael@123");

		// Find the login button and click
		Button login = browser.locateButton(LocatorType.ID, "Login");
		login.click();
		
		Button appButton = browser.locateButton(LocatorType.XPATH, "//button[@title='App Launcher']");
		appButton.click();
		
		Edit searchApp = browser.locateEdit(LocatorType.XPATH, "//input[@placeholder='Search apps and items...']");
		searchApp.type("Sales Console");
	    searchApp.pressEnter();
	    
	    Button  naviagtion = browser.locateButton(LocatorType.XPATH, "//button[@title='Show Navigation Menu']");
	    naviagtion.click();
	
	    Button lead = browser.locateButton(LocatorType.XPATH, "//a[@role='menuitem']//span[text()='Leads']");
	    lead.click();
	    
		Edit name = browser.locateEdit(LocatorType.XPATH, " //input[@name='Lead-search-input']");
		name.type(firstName);
		name.pressEnter();
		
		try{Thread.sleep(3000);}catch(Exception e) {e.printStackTrace();}
		
		String fullName = firstName + " " + lastName;
		
		//Validate the row
		Element nameElement = browser.locateElement(LocatorType.XPATH, "//a[text()='" + fullName +"']//parent::span//parent::th//following-sibling::td//span[text()='" + companyName +"']");
		boolean result = nameElement.isVisible();
		
		if( result) {System.out.println("Test is done");}else {System.out.println("Test is Not done");}
		
		browser.closeBrowser();
	}

}
