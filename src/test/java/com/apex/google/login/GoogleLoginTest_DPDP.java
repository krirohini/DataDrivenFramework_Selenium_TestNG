package com.apex.google.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.google.common.ApexBaseTest;
import com.apex.google.common.XLSUtil;

public class GoogleLoginTest_DPDP extends ApexBaseTest{

	private static final String LOCATOR_PASSWD = "Passwd";
	private static final String LOCATOR_EMAIL = "Email";
	
	@DataProvider(name="googleids")
	public Object[][] getLoginData(){
		return XLSUtil.getTableArray( "google_ids.xls", "UnitTesting", "GoogleIds");
	}

	@DataProvider(name="lockedIds")
	public Object[][] getLockedData(){
		/*String[][] userIds = {	{"user1", "password1"},
								{"user2", "password2"},
								{"user3", "password3"} 
		};
		*/
		return XLSUtil.getTableArray( "google_ids.xls", "UnitTesting", "LockedIds");
	}

	
	
	@Test(dataProvider="googleids")
	public void testGoogleLoginWithSuccessLogin(String userId, String password) throws InterruptedException {
		// Set The Data And Perform Actions

		// FIND THE USER ID AND SET DATA
		/*WebElement userid = driver.findElement(By.id(LOCATOR_EMAIL));
		userid.sendKeys("krirohini@gmail.com");*/
		
		driver.findElement(By.id(LOCATOR_EMAIL)).sendKeys(userId);

		// SET THE NEXT AND CLICK
		WebElement nextBtn = driver.findElement(By.id("next"));
		nextBtn.click();

		Thread.sleep(1000);

		// FIND THE PASSWORD SET THE PASSWORD
		/*WebElement password1 = driver.findElement(By.id(LOCATOR_PASSWD));
		password1.sendKeys("mypassword");*/
		
		driver.findElement(By.id(LOCATOR_EMAIL)).sendKeys(password);

		// CLICK ON BUTTON
		WebElement signon = driver.findElement(By.id("signIn"));
		signon.click();

		// Verify
	}

	//@DataProvider(name="googleids")
	public void testGoogleLoginWithFailedLogin() throws InterruptedException {
		// Set The Data And Perform Actions

		// FIND THE USER ID AND SET DATA
		WebElement userid = driver.findElement(By.id(LOCATOR_EMAIL));
		userid.sendKeys("krirohini@gmail.com");

		// SET THE NEXT AND CLICK
		WebElement nextBtn = driver.findElement(By.id("next"));
		nextBtn.click();

		Thread.sleep(1000);

		// FIND THE PASSWORD SET THE PASSWORD
		WebElement password = driver.findElement(By.id(LOCATOR_PASSWD));
		password.sendKeys("mypassword");

		// CLICK ON BUTTON
		WebElement signon = driver.findElement(By.id("signIn"));
		signon.click();

		// TITLE
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);

		if (pageTitle.equals("Sign in - Google Accounts")) {
			System.out.println("Test is passed");
		} else {
			System.out.println(" Test is Failed");
		}

		// Verify
		Assert.assertEquals(driver.getTitle(), "Sign in - Google Accounts");
	}

	//@Test
	public void testGoogleLoginWithBlankUserID() throws InterruptedException {
		// Set The Data And Perform Actions

		// FIND THE USER ID AND SET DATA
		WebElement userid = driver.findElement(By.id(LOCATOR_EMAIL));
		// userid.sendKeys("");

		// SET THE NEXT AND CLICK
		WebElement nextBtn = driver.findElement(By.id("next"));
		nextBtn.click();

		Thread.sleep(1000);

		if (userid.getText().length() == 0) {
			System.out.println("Test is Passed");
		} else {
			System.out.println(" Test is Failed");
		}

		/*
		 * // FIND THE PASSWORD SET THE PASSWORD WebElement password =
		 * driver.findElement(By.id("Passwd")); password.sendKeys("mypassword");
		 * 
		 * // CLICK ON BUTTON WebElement signon =
		 * driver.findElement(By.id("signIn")); signon.click();
		 */

		// Verify
		// Assert.assertEquals(driver.getTigettle(), "Sign in - Google
		// Accounts");

	}

	// @Test
	public void testGoogleLoginWithBlankPassword() {
	}

	// @Test
	public void testGoogleLoginWithBothBlank() {
	}

	@Test(dataProvider="LockedIds")
	public void testGoogleLoginWithLockedAccount(String userId, String password) {
	}

	

}
