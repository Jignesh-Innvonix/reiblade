package com.reiblade.init;

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
	
	
}
