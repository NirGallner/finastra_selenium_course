package com.finastra.wordpress.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.finastra.pageobjects.LoginPage;
/**
 * Our first test class
 * @author galln
 *
 */
public class FirstTest {
	
	// Note how WebDriver is static, since we initialize it in a static function
	private static WebDriver driver;
	
	// Only run once in the entire code
	@BeforeAll
	public static void once() throws InterruptedException {
		
		// Tell ChromeDriver where the chromedriver.exe is and create the instance
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\galln\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		// Goto wordpress site
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
		
		// Use page object to login 
		LoginPage login = new LoginPage(driver);
		login.withUser("opensourcecms")
				.withPwd("opensourcecms")
				.login();
		
	}
	
	// Will run before every test
	@BeforeEach
	public void setup() {
	}
	
	@Disabled
	@Test
	public void testPostPage() {
		
		WebElement posts = driver.findElement(By.cssSelector("#menu-posts .wp-menu-name"));
		posts.click();
		
		String title = driver.getTitle();
		Assertions.assertTrue(title.contains("Posts")
				,"page title does not contain Posts");
	}
	
	
	@Test
	public void addNewPost() throws InterruptedException {
		
		// Goto all posts
		WebElement posts = driver.findElement(By.cssSelector("#menu-posts .wp-menu-name"));
		posts.click();
		
		// Select create new post
		driver.findElement(By.cssSelector(".page-title-action")).click();
		
		// Write the title of the post - note there is a wait funcion.
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("post-title-0")));
		driver.findElement(By.id("post-title-0")).sendKeys("Title number 188");

		// Write the actual post. Does not work. We will talk about why in lesson #4
//		driver.findElement(By.cssSelector("[class='block-editor-rich-text__editable editor-rich-text__editable wp-block-paragraph']")).click();
//		driver.findElement(By.cssSelector("[class='block-editor-rich-text__editable editor-rich-text__editable wp-block-paragraph']")).sendKeys("Post # 1");
		
		// Save and publish
		driver.findElement(By.cssSelector("[class='components-button editor-post-publish-panel__toggle is-button is-primary']")).click();
		driver.findElement(By.cssSelector("[class='components-button editor-post-publish-button is-button is-default is-primary is-large']")).click();
		
		
		
	}
	
	// Will run after each test
	@AfterEach
	public void tearDown(){
	
	}
	
	// Will run at the end of all tests. Currently closes the WebDriver
	@AfterAll
	public static void finito(){
		driver.quit();
	}

}
