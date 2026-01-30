package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PomLogin {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
    // ===== Locators =====
	  private By loginLayerBtn =
	            By.id("login_Layer");

	    private By usernameField =
	            By.xpath("//input[@placeholder='Enter your active Email ID / Username']");

	    private By passwordField =
	            By.xpath("//input[@placeholder='Enter your password']");

	    private By loginBtn =
	            By.xpath("//button[text()='Login']");

	    private By profileIconAfterLogin =
	            By.xpath("//div[contains(@class,'nI-gNb-drawer__icon')]");

	
	    public PomLogin(WebDriver driver) {
	    	this.driver = driver;
	    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }
	    
	    public boolean loginToNaukri(String username, String password) {
	    	wait.until(ExpectedConditions.elementToBeClickable(loginLayerBtn)).click();
	    	
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
	    	
	    	driver.findElement(passwordField).sendKeys(password);
	    	
	    	driver.findElement(loginBtn).click();
	    	
	        // Validation: profile icon visible after login
	    	
	        return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(profileIconAfterLogin)
	        ).isDisplayed();
	    }
	    
}
