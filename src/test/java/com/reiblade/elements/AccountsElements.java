package com.reiblade.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsElements {

    @FindBy(xpath = "//div[text()='Accounts']")
    public WebElement account_page_nav_button;

    @FindBy(xpath = "//i[contains(.,'add')]")
    public WebElement account_add_button;

    @FindBy(xpath = "(//i[@class='material-icons q-icon' and text()='close'])[3]")
    public WebElement close_Button_Of_Box;

    @FindBy(xpath = "//input[contains(@aria-label,'Company')]")
    public WebElement company_text_Box;

    @FindBy(xpath = "//input[contains(@aria-label,'Monthly Max Doors')]")
    public WebElement monthly_max_doors_textBox;

    @FindBy(xpath = "//input[contains(@aria-label,'Renewal Date')]")
    public WebElement renewal_date_TextBox;

    @FindBy(xpath = " //input[contains(@aria-label,'Lifetime Max Doors')]")
    public WebElement lifeTime_Max_Doors_textBox;

    @FindBy(xpath = " (//i[text()='add'])[2]")
    public WebElement add_Button_Of_Account_User;

    @FindBy(xpath = " (//input[contains(@type,'search')])[1]")
    public WebElement search_User;

    @FindBy(xpath = "(//div[text()='Save'])[2]")
    public WebElement save_Button_Two;

    @FindBy(xpath = "//button/div[contains(@class,'q-btn__content')][contains(.,'Save')]")
    public WebElement save_Button;

    @FindBy(xpath = "//div[text()='Please resolve the errors shown.']")
    public WebElement alert_Text_Message;

    @FindBy(xpath = "//div[text()='Close ']")
    public WebElement closed_Button;

    @FindBy(xpath = "(//div[text()='Value is required'])[1]")
    public WebElement validation_Msg_One;

    @FindBy(xpath = "(//i[text()='edit'])[1]")
    public WebElement edit_button;

    @FindBy(id = "login")
    public WebElement search_emailaddress;

    @FindBy(xpath = "//*[@type ='submit']")
    public WebElement btn_search;

    @FindBy(xpath = "//a[text() =' Click HERE']")
    public WebElement click_here_text;

    @FindBy(xpath = "(//div[text() ='Set Password For New Account Link'])[1]")
    public WebElement new_Account_email_Id ;

   /* @FindBy(xpath = "//*[@type ='submit']")
    public WebElement btn_search;

    By search_emailaddress = By.id("login");
    By btn_search = By.xpath("//*[@type ='submit']");
    By password = By.xpath("//p[contains(text(),'Password:')]/strong");;
    By mail_to_name = By.xpath("//p[contains(text(),'Dear')]/strong");
    By mail_subject = By.xpath("//div[@id='mailhaut']/div[1]");
    By successmsg = By.xpath("//div[contains(text(),'Successful Sign Up!!! on BridgeVoice Online Platform')]");*/
}
