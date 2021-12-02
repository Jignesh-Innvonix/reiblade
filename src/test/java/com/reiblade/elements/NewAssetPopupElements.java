package com.reiblade.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAssetPopupElements {
	
	@FindBy(xpath = "//div[contains(@class,'tab__label')][contains(.,'Single Family (1-4)')]/../../../../../../../..//following-sibling::div/div//input[contains(@type,'search')]/..//following-sibling::div[contains(.,'Asset Type')]/..//following-sibling::div//i[contains(.,'arrow_drop_down')]")
	public WebElement single_family_asset_type;
	
	@FindBy(xpath = "//div[contains(@class,'q-menu scroll')]//div[contains(@class,'q-virtual-scroll__content')]/div[1]")
	public WebElement single_family_select_asset_type;
	
	@FindBy(xpath = "//input[contains(@aria-label,'Address1')]")
	public WebElement single_family_address1;
	
	@FindBy(xpath = "//input[contains(@aria-label,'City')]")
	public WebElement single_family_city;
	
	@FindBy(xpath = "//input[contains(@aria-label,'State')]")
	public WebElement single_family_state;
	
	@FindBy(xpath = "//input[contains(@aria-label,'Zip')]")
	public WebElement single_family_zip;
	
	@FindBy(xpath = "//div[contains(@class,'q-toolbar__title')][contains(.,'Comments')]/../button//i[contains(.,'add')]")
	public WebElement single_family_comments_add_button;
	
	@FindBy(xpath = "//input[contains(@aria-label,'Title')]")
	public WebElement single_family_comments_new_title;
	
	@FindBy(xpath = "//div[contains(@class,'q-editor__content')]")
	public WebElement single_family_comments_new_desc;
	
	@FindBy(xpath = "//button/div[contains(@class,'q-btn__content')][contains(.,'Save')]")
	public WebElement single_family_comments_new_save_btn;
	
	@FindBy(xpath = "//button/div[contains(@class,'q-btn__content')][contains(.,'Cancel')]")
	public WebElement single_family_comments_new_cancel_btn;
}
