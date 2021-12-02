package com.reiblade.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardElements {

	@FindBy(xpath = "//div[contains(@class,'topBar')]/button[contains(@class,'navmenu')]")
	public static WebElement navigation_menu_icon;
	
}
