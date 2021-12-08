package com.reiblade.accounts;

import com.reiblade.elements.AccountsElements;
import com.reiblade.elements.DashboardElements;
import com.reiblade.elements.LeftMenuModulesElements;
import com.reiblade.elements.LoginElements;
import com.reiblade.init.Common;
import com.reiblade.init.GenericFunctions;
import com.reiblade.init.PropertiesFile;
import com.reiblade.init.TestBase;
import com.reiblade.sponsors.SponsorsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class AccopuntsTest {
    AccountsPage accountsPage;
    WebDriver driver;
    PropertiesFile url;
    LoginElements loginElement;
    LeftMenuModulesElements leftMenuModulesElements;
    AccountsElements accountsElements;
    DashboardElements dashboardElements;

    public AccopuntsTest() throws Exception {
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

            accountsPage = PageFactory.initElements(driver, AccountsPage.class);
            loginElement = PageFactory.initElements(this.driver, LoginElements.class);
            leftMenuModulesElements = PageFactory.initElements(this.driver, LeftMenuModulesElements.class);
            accountsElements = PageFactory.initElements(this.driver, AccountsElements.class);
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
        GenericFunctions.clickOn(leftMenuModulesElements.account_menu);
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(accountsElements.account_add_button);
        GenericFunctions.pause(5);

        GenericFunctions.elementIsDisplayd(accountsElements.company_text_Box);
        GenericFunctions.pause(2);
        GenericFunctions.elementIsDisplayd(accountsElements.monthly_max_doors_textBox);
        GenericFunctions.pause(2);
        GenericFunctions.elementIsDisplayd(accountsElements.renewal_date_TextBox);
        GenericFunctions.elementIsDisplayd(accountsElements.lifeTime_Max_Doors_textBox);
        GenericFunctions.clickOn(accountsElements.close_Button_Of_Box);
        System.out.println("----verify_Required_Filled_functionality Test Completed");
    }

   @Test(priority = 2)
    public void verify_Validation_Message_functionality() throws Exception {
        GenericFunctions.pause(5);
        GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(leftMenuModulesElements.account_menu);
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(accountsElements.account_add_button);
        GenericFunctions.pause(5);

        GenericFunctions.jsClick(driver, accountsElements.save_Button);
        GenericFunctions.pause(2);
        GenericFunctions.elementIsDisplayd(accountsElements.alert_Text_Message);
        GenericFunctions.clickOn(accountsElements.closed_Button);
        GenericFunctions.elementIsDisplayd(accountsElements.validation_Msg_One);

        GenericFunctions.clickOn(accountsElements.close_Button_Of_Box);
        System.out.println("----verify_Validation_Message_functionality Test Completed");
    }

   @Test(priority = 3)
    public void verify_Add_Message_functionality() throws Exception {
        GenericFunctions.pause(5);
        GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(leftMenuModulesElements.account_menu);
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(accountsElements.account_add_button);
        GenericFunctions.pause(5);
        GenericFunctions.enterValueInto(accountsElements.company_text_Box,"Jignesh Company");
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(accountsElements.add_Button_Of_Account_User);
        GenericFunctions.pause(2);
        GenericFunctions.enterValueInto(accountsElements.search_User, "Jignesh");
        GenericFunctions.pause(1);
        GenericFunctions.sendKeys(accountsElements.search_User,  Keys.DOWN);
        GenericFunctions.pause(1);
        GenericFunctions.sendKeys(accountsElements.search_User,  Keys.ENTER);
        GenericFunctions.pause(1);
        GenericFunctions.jsClick(driver, accountsElements.save_Button_Two);
        GenericFunctions.pause(1);
        GenericFunctions.jsClick(driver, accountsElements.save_Button);
        GenericFunctions.pause(6);
        WebElement accountName = driver.findElement(By.xpath("(//div[text()='Jignesh Company'])[1]"));
        GenericFunctions.elementIsDisplayd(accountName);
        System.out.println("----verify_Add_Message_functionality Test Completed");
    }

    @Test(priority = 4)
    public void verify_Edit_Account_functionality() throws Exception {
        GenericFunctions.pause(5);
        GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(leftMenuModulesElements.account_menu);
        GenericFunctions.pause(3);
        GenericFunctions.clickOn(leftMenuModulesElements.navigation_menu_icon);
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(accountsElements.edit_button);
        GenericFunctions.pause(5);
        GenericFunctions.clearAndEnterValueInto(accountsElements.monthly_max_doors_textBox, "10000");
        GenericFunctions.jsClick(driver, accountsElements.save_Button);
        GenericFunctions.pause(6);
        WebElement emailId = driver.findElement(By.xpath("(//div[text()='10000'])[1]"));
        GenericFunctions.elementIsDisplayd(emailId);
        System.out.println("----verify_Edit_Sponsor_functionality Test Completed");
    }


   // @Test(priority = 4)
    public void verify_Notification() throws Exception {
        GenericFunctions.pause(2);
       // driver.switchTo().window(tabs2.get(1));
        driver.get("https://yopmail.com/en/");
        GenericFunctions.pause(5);
        accountsPage.searchEmail("jigneshyopmail123@yopmail.com");
        GenericFunctions.pause(2);
        GenericFunctions.clickOn(accountsElements.new_Account_email_Id);
        GenericFunctions.pause(1);
        GenericFunctions.jsClick(driver,accountsElements.click_here_text);
    }
}
