package com.reiblade.sponsors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		url = new PropertiesFile(userDirectory + "//Data//url Configuration.properties");

	}

	@BeforeTest
	public void initialization() throws Exception {
		try {
			driver = TestBase.init();
			try {
				driver.get(url.adminURL());
			} catch (Exception e) {
				driver.get(url.adminURL());
			}

			sponsorsPage = PageFactory.initElements(driver, SponsorsPage.class);
			loginElement = PageFactory.initElements(this.driver, LoginElements.class);
			leftMenuModulesElements = PageFactory.initElements(this.driver, LeftMenuModulesElements.class);
			sponsorsElements = PageFactory.initElements(this.driver, SponsorsElements.class);
			dashboardElements = PageFactory.initElements(this.driver, DashboardElements.class);

			System.out.println("----Welcome to signIn");

			GenericFunctions.enterValueInto(loginElement.login_userName, url.adminUserName());
			GenericFunctions.enterValueInto(loginElement.login_password, url.adminPassword());
			GenericFunctions.clickOn(loginElement.loginBtn);

		} catch (Exception e) {
			Common.Screenshot(driver, " Web signInTest - Fail ", "BeforeMethod - initialization");
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
	public void verify_Required_Filled_functionality() throws Exception {
		GenericFunctions.pause(5);
		GenericFunctions.clickOn(leftMenuModulesElements.sponsors_menu);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(sponsorsElements.sponsors_add_button);
		GenericFunctions.pause(5);

		GenericFunctions.elementIsDisplayd(sponsorsElements.first_Name_TextBox);
		GenericFunctions.pause(2);
		GenericFunctions.elementIsDisplayd(sponsorsElements.last_Name_TextBox);
		GenericFunctions.pause(2);
		GenericFunctions.elementIsDisplayd(sponsorsElements.cell_Phone_TextBox);
		GenericFunctions.elementIsDisplayd(sponsorsElements.username_TextBox);
		GenericFunctions.elementIsDisplayd(sponsorsElements.address_One_TextBox);
		GenericFunctions.elementIsDisplayd(sponsorsElements.address_Two_TextBox);
		GenericFunctions.elementIsDisplayd(sponsorsElements.city_TextBox);
		GenericFunctions.elementIsDisplayd(sponsorsElements.state_TextBox);
		GenericFunctions.elementIsDisplayd(sponsorsElements.country_TextBox);
		GenericFunctions.elementIsDisplayd(sponsorsElements.postal_code_TextBox);
		GenericFunctions.elementIsDisplayd(sponsorsElements.landline_TextBox);
		GenericFunctions.clickOn(sponsorsElements.close_Button_Of_Box);

		System.out.println("----verify_Required_Filled_functionality Test Completed");
	}

	@Test(priority = 2)
	public void verify_Validation_Message_functionality() throws Exception {
		GenericFunctions.pause(5);
		GenericFunctions.clickOn(leftMenuModulesElements.sponsors_menu);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(sponsorsElements.sponsors_add_button);
		GenericFunctions.pause(5);
		GenericFunctions.jsClick(driver, sponsorsElements.save_Button);
		GenericFunctions.pause(2);
		GenericFunctions.elementIsDisplayd(sponsorsElements.alert_Text_Message);
		GenericFunctions.clickOn(sponsorsElements.closed_Button);
		GenericFunctions.elementIsDisplayd(sponsorsElements.validation_Msg_One);
		GenericFunctions.elementIsDisplayd(sponsorsElements.validation_Msg_Two);
		GenericFunctions.elementIsDisplayd(sponsorsElements.validation_Msg_Three);
		GenericFunctions.clickOn(sponsorsElements.close_Button_Of_Box);

		System.out.println("----verify_Validation_Message_functionality Test Completed");
	}

	@Test(priority = 3)
	public void verify_Add_Sponsor_functionality() throws Exception {
		GenericFunctions.pause(5);
		GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(leftMenuModulesElements.sponsors_menu);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(sponsorsElements.sponsors_add_button);
		GenericFunctions.pause(5);
		GenericFunctions.enterValueInto(sponsorsElements.first_Name_TextBox, "Jignesh");
		GenericFunctions.enterValueInto(sponsorsElements.last_Name_TextBox, "Shah");
		GenericFunctions.enterValueInto(sponsorsElements.email_TextBox, "jignesh.shah@innvonix.com");
		GenericFunctions.pause(1);
		GenericFunctions.jsClick(driver, sponsorsElements.save_Button);
		GenericFunctions.pause(1);
		GenericFunctions.clickOn(sponsorsElements.close_Button_Of_Box);
		GenericFunctions.pause(3);
		WebElement firstName = driver.findElement(By.xpath("(//div[text()='Jignesh'])[1]"));
		GenericFunctions.elementIsDisplayd(firstName);
		WebElement lastName = driver.findElement(By.xpath("(//div[text()='Shah'])[1]"));
		GenericFunctions.elementIsDisplayd(lastName);
		WebElement emailId = driver.findElement(By.xpath("(//div[text()='jignesh.shah@innvonix.com'])[1]"));
		GenericFunctions.elementIsDisplayd(emailId);
		System.out.println("----verify_Add_Sponsor_functionality Test Completed");
	}

	@Test(priority = 4)
	public void verify_Edit_Sponsor_functionality() throws Exception {
		GenericFunctions.pause(5);
		GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(leftMenuModulesElements.sponsors_menu);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(sponsorsElements.edit_button);
		GenericFunctions.pause(5);
		GenericFunctions.enterValueInto(sponsorsElements.first_Name_TextBox, "edit");
		GenericFunctions.enterValueInto(sponsorsElements.first_Name_TextBox, "edit");
		GenericFunctions.clearAndEnterValueInto(sponsorsElements.email_TextBox, "shah.j@innvonix.com");
		GenericFunctions.jsClick(driver, sponsorsElements.save_Button);
		GenericFunctions.pause(1);
		GenericFunctions.clickOn(sponsorsElements.close_Button_Of_Box);
		GenericFunctions.pause(3);
		//WebElement firstName = driver.findElement(By.xpath("(//div[text()='Jignesh'])[1]"));
		//GenericFunctions.elementIsDisplayd(firstName);
		//WebElement lastName = driver.findElement(By.xpath("(//div[text()='Shah'])[1]"));
		//GenericFunctions.elementIsDisplayd(lastName);
		WebElement emailId = driver.findElement(By.xpath("(//div[text()='shah.j@innvonix.com'])[1]"));
		GenericFunctions.elementIsDisplayd(emailId);
		System.out.println("----verify_Edit_Sponsor_functionality Test Completed");
	}

	@Test(priority = 5)
	public void verify_Delete_Sponsor_functionality() throws Exception {
		GenericFunctions.pause(5);
		GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(leftMenuModulesElements.sponsors_menu);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(sponsorsElements.checkBox);
		GenericFunctions.pause(2);
		GenericFunctions.clickOn(sponsorsElements.moreOption);
		GenericFunctions.pause(1);
		GenericFunctions.clickOn(sponsorsElements.delete_Button_From_More_Option);
		GenericFunctions.pause(1);
		GenericFunctions.clickOn(sponsorsElements.delete_Confirmation_Alert);
		GenericFunctions.pause(1);
		GenericFunctions.clickOn(sponsorsElements.delete_Button_On_Alert);
		GenericFunctions.pause(1);
		System.out.println("----verify_Delete_Sponsor_functionality Test Completed");
	}
}
