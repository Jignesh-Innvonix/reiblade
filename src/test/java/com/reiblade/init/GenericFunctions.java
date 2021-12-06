package com.reiblade.init;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import groovyjarjarantlr4.v4.codegen.model.Action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class GenericFunctions {
	
	WebDriver driver;
	static WebDriverWait wait;
	

	public GenericFunctions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 100);
	}
	
	public static void pause(int secs) {
		try {
			Thread.sleep(secs * 1000);
			/*
			 * SeleniumInit.tim=SeleniumInit.tim+secs;
			 * System.out.println(" Pause wait --> "+SeleniumInit.tim);
			 */
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}

	public static int generateRandomNumber() {
		Random rand = new Random();
		int value = rand.nextInt(5000);
		return value;
	}

	public static String generateRandomAlphaNumber() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		;
		return uuid;
	}

	public static void systemDateAndTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
	}


	public static void enterValueInto(WebElement webElement, String value)  {
//		webElement.clear();
		pause(2);
		webElement.sendKeys(value);
	}
	
	public static void clickOn(WebElement webElement) {
//		wait.until(ExpectedConditions.visibilityOf(webElement));
		webElement.click();
	}


	public static void jsClick(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("return arguments[0].click();", element);
		// this.waitForAjax("0");
	}

	public static void jsSendKey(WebDriver driver, WebElement element, String text) {

		// WebElement el = driver.findElement(toByVal(element));
//		    JavascriptExecutor ex = (JavascriptExecutor) driver;
//		    ex.executeScript("arguments[0].value='"+ text +"';", element);
//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementByXpath('some id').value='someValue';");
	}

	public static By toByVal(WebElement we) {
		// By format = "[foundFrom] -> locator: term"
		// see RemoteWebElement toString() implementation
		String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
		String locator = data[0];
		String term = data[1];

		switch (locator) {
			case "xpath":
				return By.xpath(term);
			case "css selector":
				return By.cssSelector(term);
			case "id":
				return By.id(term);
			case "tag name":
				return By.tagName(term);
			case "name":
				return By.name(term);
			case "link text":
				return By.linkText(term);
			case "class name":
				return By.className(term);
		}
		return (By) we;
	}
	
	
}
