package com.reiblade.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class LoginElements {
	
//	LoginElements loginElement;
//	static Webdriver driver;
	
//	public LoginElements(WebDriver driver) {
//		loginElement = PageFactory.initElements(driver, LoginElements.class);
//	}

	@FindBy(xpath = "//input[contains(@name,'login')]")
	public static WebElement login_userName;
	
	@FindBy(xpath = "//input[contains(@name,'password')]")
	public WebElement login_password;
	
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	public WebElement loginBtn;
	
	@FindBy(xpath = "//span[contains(.,'Welcome,')]")
	WebElement welcomeTxt;
	
	
	
}
