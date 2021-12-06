package com.reiblade.sponsors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.reiblade.asset.AssetPage;
import com.reiblade.elements.DashboardElements;
import com.reiblade.elements.LeftMenuModulesElements;
import com.reiblade.elements.LoginElements;
import com.reiblade.elements.NewAssetPopupElements;
import com.reiblade.elements.SponsorsElements;
import com.reiblade.init.Common;
import com.reiblade.init.GenericFunctions;
import com.reiblade.init.PropertiesFile;
import com.reiblade.init.TestBase;

public class SponsorsTest {
	SponsorsPage sponsorsPage;
	WebDriver driver;
	PropertiesFile url;
	LoginElements loginElement;
	LeftMenuModulesElements leftMenuModulesElements;
	SponsorsElements sponsorsElements;
	DashboardElements dashboardElements;

	public SponsorsTest() throws Exception {
		String userDirectory = System.getProperty("user.dir");
		url = new PropertiesFile(userDirectory + "//Data//url Configuration.properties" );

	}

	@BeforeTest
	public void initialization() throws Exception {
		try {
			driver = TestBase.init();
			try {
				driver.get(url.adminURL());
			}catch(Exception e) {
				driver.get(url.adminURL());
			}

			sponsorsPage = PageFactory.initElements(driver, SponsorsPage.class);
			loginElement = PageFactory.initElements(this.driver, LoginElements.class);
			leftMenuModulesElements = PageFactory.initElements(this.driver, LeftMenuModulesElements.class);
			sponsorsElements = PageFactory.initElements(this.driver, SponsorsElements.class);
			dashboardElements = PageFactory.initElements(this.driver, DashboardElements.class);

			System.out.println("----Welcome to signIn");


			GenericFunctions.enterValueInto(loginElement.login_userName,url.adminUserName());
			GenericFunctions.enterValueInto(loginElement.login_password,url.adminPassword());
			GenericFunctions.clickOn(loginElement.loginBtn);


		} catch (Exception e) {
			Common.Screenshot(driver," Web signInTest - Fail ","BeforeMethod - initialization");
			System.out.println("----Need to check issue in - signInTest - BeforeMethod - initialization----");
		}
	}


	@AfterMethod
	public void endTestWork(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {
			String testname = "Fail";
			Common.Screenshot(driver, testname, " Fail " + result.getMethod().getMethodName());
			System.out.println(testname + " - " + result.getMethod().getMethodName());

		} else {
			String testname = "Pass";
			Common.Screenshot(driver, testname, " Pass " + result.getMethod().getMethodName());
			System.out.println(testname + " - " + result.getMethod().getMethodName());
		}

	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verify_add_asset_functionality() throws Exception {
		GenericFunctions.pause(5);
		GenericFunctions.clickOn(leftMenuModulesElements.sponsors_menu);//navigation_menu_icon
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(sponsorsElements.sponsors_add_button);
		GenericFunctions.pause(5);
		//	GenericFunctions.clickOn(sponsorsElements.closeButton);

//		GenericFunctions.jsClick(driver, sponsorsElements.first_Name_TextBox);
//		GenericFunctions.enterValueInto(sponsorsElements.first_Name_TextBox, "Jignesh");
		GenericFunctions.jsClick(driver, sponsorsElements.last_Name_TextBox);
		GenericFunctions.pause(2);

		GenericFunctions.jsSendKey(driver,sponsorsElements.last_Name_TextBox, "Shah");
//		GenericFunctions.pause(2);
		GenericFunctions.enterValueInto(sponsorsElements.email_TextBox, "jignesh.shah@innvonix.com");
		GenericFunctions.pause(2);
		GenericFunctions.jsClick(driver,sponsorsElements.save_Button);
		System.out.println("----Sponosors Test Completed");
	}
}
