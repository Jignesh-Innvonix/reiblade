package com.reiblade.accounts;

import com.reiblade.elements.LeftMenuModulesElements;
import com.reiblade.elements.LoginElements;
import com.reiblade.init.Common;
import com.reiblade.init.GenericFunctions;
import com.reiblade.init.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

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
}
