package com.apex.google.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ApexBaseTest {
	
	protected WebDriver driver = null;

	@BeforeMethod
	public void setup() {
		// Create The Driver
		driver = new FirefoxDriver();

		// Open The Url
		driver.get("http://saipratap.net/ecommerce/customerlogin.php");
	}

	@AfterMethod
	public void teardown() {
		// Close The Driver
		driver.close();
	}


}
