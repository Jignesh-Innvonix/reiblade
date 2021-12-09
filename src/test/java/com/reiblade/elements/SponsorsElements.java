package com.reiblade.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SponsorsElements {

	@FindBy(xpath = "//input[contains(@aria-label,'First Name')]")
	public WebElement first_Name_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'Last Name')]")
	public WebElement last_Name_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'Email')]")
	public WebElement email_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'Cell Phone')]")
	public WebElement cell_Phone_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'Username')]")
	public WebElement username_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'Address1')]")
	public WebElement address_One_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'Address2')]")
	public WebElement address_Two_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'City')]")
	public WebElement city_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'State')]")
	public WebElement state_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'Country')]")
	public WebElement country_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'Postal Code')]")
	public WebElement postal_code_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'Landline')]")
	public WebElement landline_TextBox;

	@FindBy(xpath = "//input[contains(@aria-label,'Job Title')]")
	public WebElement job_title_textBox;

	@FindBy(xpath = "//i[contains(.,'add')]")
	public WebElement sponsors_add_button;

	@FindBy(xpath = "//button/div[contains(@class,'q-btn__content')][contains(.,'Save')]")
	public WebElement save_Button;

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

	@FindBy(xpath = "//td[contains(@class,'q-table')]/div[1]/div/div")
	public WebElement checkBox;

	@FindBy(xpath = "//i[text()='more_vert']")
	public WebElement moreOption;

	@FindBy(xpath = "//div[text()='Delete']")
	public WebElement delete_Button_From_More_Option;

	@FindBy(xpath = "//div[text()='Delete Confirmation!']")
	public WebElement delete_Confirmation_Alert;
	
	@FindBy(xpath = "//div[text()='Delete ']")
	public WebElement delete_Button_On_Alert;

}
