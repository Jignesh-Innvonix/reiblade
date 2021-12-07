package com.reiblade.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.reiblade.init.Common;

public class LeftMenuModulesElements {
	
	@FindBy(xpath = "//div[contains(@class,'topBar')]/button[contains(@class,'navmenu')]")
	public WebElement navigation_menu_icon;
	
	@FindBy(xpath = "//i[contains(.,'location_city')]/..//following-sibling::div/i[contains(@class,'rotate-180')]")
	public WebElement asset_leftmenu_down_arrow;
	
	@FindBy(xpath = "//i[contains(.,'location_city')]/..//following-sibling::div/div[contains(.,'Assets')]")
	public WebElement asset_leftmenu_location_city;
	
	@FindBy(xpath = "//i[contains(.,'house')]/..//following-sibling::div[contains(.,'Assets')]")
	public WebElement asset_leftmenu_house;

	@FindBy(xpath = "//div[contains(@class,'toolbar__title')][contains(.,'Assets')]//i[contains(.,'add')]")
	public WebElement asset_add_button;
	
	@FindBy(xpath = "//table[@class='q-table']//tr[1]/td[1]//i[contains(@class,'editicon')]")
	public WebElement asset_edit_button;
	
	@FindBy(xpath = "//div[text()='Sponsors']")
	public WebElement sponsors_menu;
	
	@FindBy(xpath = "//div[text()='Accounts']")
	public WebElement account_menu;
	
}
