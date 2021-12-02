package com.reiblade.init;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	static WebDriver driver;

	public static WebDriver init() {
		DesiredCapabilities dc = new DesiredCapabilities();
		String userDirectory = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userDirectory+ "//Data//chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--use-fake-ui-for-media-stream");
		
		HashMap<String, Object> chromePref = new HashMap<>();

		chromePref.put("download.default_directory", System.getProperty("user.dir")+"\\download_files");

		options.setExperimentalOption("prefs", chromePref);
		
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		return driver;

	}

	

	


}
