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

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement checkBox;

    @FindBy(xpath = "//i[text()='more_vert']")
    public WebElement moreOption;

    @FindBy(xpath = "//div[text()='Delete']")
    public WebElement delete_Button_From_More_Option;

    @FindBy(xpath = "//div[text()='Delete Confirmation!']")
    public WebElement delete_Confirmation_Alert;
    //div[text()='Delete Confirmation!']
    @FindBy(xpath = "//div[text()='Delete ']")
    public WebElement delete_Button_On_Alert;

    @FindBy(id = "login")
    public WebElement search_emailaddress;

    @FindBy(xpath = "//a[@class='wmlogoclick']")
    public WebElement btn_search;

    @FindBy(xpath = "//a[text() =' Click HERE']")
    public WebElement click_here_text;

    @FindBy(xpath = "(//div[text() ='Set Password For New Account Link'])[1]")
    public WebElement new_Account_email_Id ;

    @FindBy(xpath = "//input[contains(@aria-label,'Enter New Password')]")
    public WebElement enterNewPassword;

    @FindBy(xpath = "//input[contains(@aria-label,'Repeat New Password')]")
    public WebElement repeatNewPassword;

    @FindBy(id = "resetpasswordbtn")
    public WebElement reset_Password_Button;


}
