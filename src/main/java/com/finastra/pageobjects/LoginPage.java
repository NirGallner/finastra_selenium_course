package com.finastra.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Implements WordPress demo site login page
 * @author galln
 *
 */
public class LoginPage {
	
	private WebDriver driver;
	
	// Note how we get the driver in the c-tor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// We fill in the username text box and return this, in order to chain calls
	public LoginPage withUser(String username) {
		driver.findElement(By.id("user_login")).sendKeys(username);
		return this;
	}
	
	// We fill in the password text box and return this, in order to chain calls
	public LoginPage withPwd(String pwd) {
		driver.findElement(By.id("user_pass")).sendKeys(pwd);
		return this;
	}
	
	// Currently returns void, but late on will be used to return dashboasd page and use page flow mechanism
	public void login() {
		driver.findElement(By.id("wp-submit")).click();
	}

}
