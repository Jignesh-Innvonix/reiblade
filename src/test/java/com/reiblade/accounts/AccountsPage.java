package com.reiblade.accounts;

import com.reiblade.elements.AccountsElements;
import com.reiblade.elements.LeftMenuModulesElements;
import com.reiblade.elements.LoginElements;
import com.reiblade.init.Common;
import com.reiblade.init.GenericFunctions;
import com.reiblade.init.PropertiesFile;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    static WebDriver driver;
    static WebDriver  logindriver;
    WebDriverWait wait;
    Actions action;
    PropertiesFile credential;
    SoftAssert softAssert;
    LoginElements loginElement;
    LeftMenuModulesElements leftMenuModulesElements;
    AccountsElements accountsElements;
    Common commonobj;



    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 100);
        action = new Actions(this.driver);
        try {
            credential = new PropertiesFile("Data\\url Configuration.properties");
        } catch (Exception e) {
        }
        softAssert = new SoftAssert();
        commonobj = new Common();
        loginElement = PageFactory.initElements(this.driver, LoginElements.class);
        leftMenuModulesElements = PageFactory.initElements(this.driver, LeftMenuModulesElements.class);
        accountsElements = PageFactory.initElements(this.driver, AccountsElements.class);
    }

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


    public void clickOn_assets_leftmenu_location_city() {
        Common.pause(1);
        List<WebElement> asset_down_arrow = driver.findElements(By.xpath("//i[contains(.,'location_city')]/..//following-sibling::div/i[contains(@class,'rotate-180')]"));
        System.out.println("----Tasset_down_arrow.size()---"+asset_down_arrow.size());
        if (asset_down_arrow.size()==0)
        {
            GenericFunctions.clickOn(leftMenuModulesElements.asset_leftmenu_location_city);
        }
    }

    public void waitTillElementIsVisible(int timeInSeconds, By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            throw new ElementNotVisibleException("element was not visible in " + timeInSeconds + " seconds");
        }
    }
    public void searchEmail(String emailaddress) {
        System.out.println("Search " + emailaddress + " in Mail");
        Common.pause(5);

        GenericFunctions.clearAndEnterValueInto(accountsElements.search_emailaddress, emailaddress);

        Common.pause(2);
        GenericFunctions.sendKeys(accountsElements.search_emailaddress,  Keys.ENTER);
        Common.pause(2);
        driver.switchTo().frame("ifinbox");
        Common.pause(2);
    }

    public void clickOnClickHerePasswordLink() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("ifmail");
        Common.pause(2);
        GenericFunctions.clickOn(accountsElements.click_here_text);
    }

    public void switchTab(){
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
    }

}
