package com.finastra.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class first {
	
	/**
	 * This is the first example to show how to use with Selenium WebDriver
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String args[]) throws InterruptedException {
		
		// You need to set chromedriver.exe path to the correct path on your computer
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\galln\\Downloads\\chromedriver.exe");
		
		// Create a new instance of ChromeDriver. Note how WebDriver is just an interface
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		// Google search text box
		WebElement element = driver.findElement(By.xpath("//*[@name='p']"));
		element.sendKeys("Finastra");
		element.sendKeys(Keys.ENTER);
		
		// We will NOT(!!!) use this in our projects. It's for demonstration purposes only
		Thread.sleep(3000);
		driver.quit();
	}

}
