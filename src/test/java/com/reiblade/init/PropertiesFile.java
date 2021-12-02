package com.reiblade.init;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertiesFile {

	public static Properties prop;

	public PropertiesFile(String filepath1) throws Exception {

		FileReader reader = new FileReader(filepath1);
		prop = new Properties();
		prop.load(reader);
	}

	public String signIn() throws IOException {

		return prop.getProperty("signIn");
	}

	public String userName() throws IOException {

		return prop.getProperty("userName");
	}

	public String password() throws IOException {

		return prop.getProperty("password");
	}

	public String adminURL() throws IOException {

		return prop.getProperty("adminURL");
	}

	public String adminUserName() throws IOException {

		return prop.getProperty("adminUserName");
	}

	public String adminPassword() throws IOException {

		return prop.getProperty("adminPassword");
	}
}
