package com.reiblade.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SponsorsElements {

	@FindBy(xpath = "(//i[text()='close'])[3]")
	public WebElement closeButton;
	
	@FindBy(xpath = "//div[contains(text(),'First Name')]")
	public WebElement first_Name_TextBox;

	@FindBy(xpath = "//div[contains(text(),'Last Name')]")
	public WebElement last_Name_TextBox;

	@FindBy(xpath = "//div[contains(text(),'Email')]")
	public WebElement email_TextBox;

	@FindBy(xpath = "//button/div[contains(@class,'q-btn__content')][contains(.,'Save')]")
	public WebElement save_Button;

	@FindBy(xpath = "//i[contains(.,'add')]")
	public WebElement sponsors_add_button;

	@FindBy(xpath = "//div[text()='Please resolve the errors shown.']")
	public WebElement alert_Text_Message;

	@FindBy(xpath = "//div[text()='Close ']")
	public WebElement closed_Button;

	@FindBy(xpath = "(//div[text()='Value is required'])[1]")
	public WebElement validation_Msg_One;

	@FindBy(xpath = "(//div[text()='Value is required'])[2]")
	public WebElement validation_Msg_Two;

	@FindBy(xpath = "(//div[text()='Value is required'])[3]")
	public WebElement validation_Msg_Three;

	@FindBy(xpath = "(//i[@class='material-icons q-icon' and text()='close'])[3]")
	public WebElement close_Button_Of_Box;

	@FindBy(xpath = "(//i[text()='edit'])[1]")
	public WebElement edit_button;
}
