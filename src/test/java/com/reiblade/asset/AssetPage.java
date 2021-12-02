package com.reiblade.asset;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.PageFactory;

import com.reiblade.elements.*;
import com.reiblade.init.Common;
import com.reiblade.init.GenericFunctions;
import com.reiblade.init.PropertiesFile;

public class AssetPage {

	static WebDriver driver;
	static WebDriver  logindriver;
	WebDriverWait wait;
	Actions action;
	PropertiesFile credential;
	SoftAssert softAssert;
	LoginElements loginElement;
	LeftMenuModulesElements leftMenuModulesElements;
	Common commonobj;

	
	
	public AssetPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 100);
		action = new Actions(this.driver);
		try {
			credential = new PropertiesFile("Data\\url Configuration.properties");
		} catch (Exception e) {
		}
		softAssert = new SoftAssert();
		commonobj = new Common();
//		loginElement = new LoginElements(this.driver);
		loginElement = PageFactory.initElements(this.driver, LoginElements.class);
		leftMenuModulesElements = PageFactory.initElements(this.driver, LeftMenuModulesElements.class);
	}
	
//	@FindBy(xpath = "//input[contains(@name,'login')]")
//	WebElement login_userName;
//	
//	@FindBy(xpath = "//input[contains(@name,'password')]")
//	WebElement login_password;
//	
//	@FindBy(xpath = "//button[contains(@class,'login-button')]")
//	WebElement loginBtn;
//	
//	@FindBy(xpath = "//span[contains(.,'Welcome,')]")
//	WebElement welcomeTxt;
	
	
	public void insert_login_userName(String loginUserName) {
		Common.pause(1);
		commonobj.type(loginElement.login_userName,loginUserName);
	}
	
	public void insert_login_password(String loginPassword) {
		Common.pause(1);
		loginElement.login_password.sendKeys(loginPassword);
	}
	
	public void click_loginBtn() {
		Common.pause(1);
		loginElement.loginBtn.click();
	}
	
//	public String verify_dashboadPage() {
//		Common.pause(1);
//		wait.until(ExpectedConditions.visibilityOf(welcomeTxt));
//		return welcomeTxt.getText();
//	}
	
	public void clickOn_assets_leftmenu_location_city() {
		Common.pause(1);
		List<WebElement> asset_down_arrow = driver.findElements(By.xpath("//i[contains(.,'location_city')]/..//following-sibling::div/i[contains(@class,'rotate-180')]"));
		System.out.println("----Tasset_down_arrow.size()---"+asset_down_arrow.size());
		if (asset_down_arrow.size()==0)
		{
			GenericFunctions.clickOn(leftMenuModulesElements.asset_leftmenu_location_city);
		}
	}
	
}
