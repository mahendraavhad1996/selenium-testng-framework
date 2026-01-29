package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By username = By.id("usernameField");
	By password = By.id("passwordField");
	By loginBtn = By.xpath("//button[normalize-space(.)='Login']");
	By viewProfile = By.xpath("//div[contains(@class,'view-profile')]//a");
	By editProfile = By.xpath("//em[normalize-space(.)='editOneTheme' and contains(@class,'icon edit')]");
	By btnSave = By.xpath("//button[normalize-space(.)='Save']");

	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String user, String pass) throws InterruptedException {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
		Thread.sleep(10000);
		System.out.println("Log in successfully---------------");
		
		driver.findElement(viewProfile).click();
		System.out.println("Profile view successfully---------------");
		Thread.sleep(10000);

		driver.findElement(editProfile).click();
		System.out.println("edit Profile window opned successfully---------------");
		Thread.sleep(10000);
		
		driver.findElement(btnSave).click();
		System.out.println("Profile details saved successfully---------------");
		Thread.sleep(10000);
	}


}
