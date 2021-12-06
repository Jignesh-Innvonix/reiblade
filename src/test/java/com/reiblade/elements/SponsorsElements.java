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
}
