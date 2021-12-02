package com.reiblade.sponsors;

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
	NewAssetPopupElements newAssetPopupElements;
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
			newAssetPopupElements = PageFactory.initElements(this.driver, NewAssetPopupElements.class);
			dashboardElements = PageFactory.initElements(this.driver, DashboardElements.class);
			
			System.out.println("----Welcome to signIn");
//			assetPage.insert_login_userName(url.userName());
//			assetPage.insert_login_password(url.password());
//			assetPage.click_loginBtn();
//			assertEquals(assetPage.verify_dashboadPage(), "Welcome,");
			
			GenericFunctions.enterValueInto(loginElement.login_userName,url.adminUserName());
			GenericFunctions.clickOn(loginElement.login_password);
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
		GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
		//assetPage.clickOn_assets_leftmenu_location_city();
		GenericFunctions.pause(1);
		GenericFunctions.clickOn(leftMenuModulesElements.asset_leftmenu_house);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(leftMenuModulesElements.asset_add_button);
		GenericFunctions.pause(10);
		GenericFunctions.clickOn(newAssetPopupElements.single_family_asset_type);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(newAssetPopupElements.single_family_select_asset_type);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(newAssetPopupElements.single_family_address1);
		GenericFunctions.enterValueInto(newAssetPopupElements.single_family_address1,"Aatithya2");
		GenericFunctions.enterValueInto(newAssetPopupElements.single_family_city,"Ahmedabad");
		GenericFunctions.enterValueInto(newAssetPopupElements.single_family_state,"Guajarat");
		GenericFunctions.enterValueInto(newAssetPopupElements.single_family_zip,"380054");
		GenericFunctions.pause(3);
		
		GenericFunctions.jsClick(driver,newAssetPopupElements.single_family_comments_add_button);
		GenericFunctions.enterValueInto(newAssetPopupElements.single_family_comments_new_title,"Test");
		GenericFunctions.enterValueInto(newAssetPopupElements.single_family_comments_new_desc,"test1");
		GenericFunctions.jsClick(driver,newAssetPopupElements.single_family_comments_new_save_btn);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(leftMenuModulesElements.asset_edit_button);
//		GenericFunctions.jsClick(driver,newAssetPopupElements.single_family_comments_new_save_btn);
		GenericFunctions.pause(2);
		GenericFunctions.jsClick(driver,newAssetPopupElements.single_family_comments_new_cancel_btn);

		System.out.println("----Test Completed");
	}
}
