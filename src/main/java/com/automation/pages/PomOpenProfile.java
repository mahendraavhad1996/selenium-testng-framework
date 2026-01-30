package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PomOpenProfile {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Locators =====
    private By profileIcon =
            By.xpath("//div[contains(@class,'nI-gNb-drawer__icon')]");

    private By viewProfileLink =
            By.xpath("//a[text()='View Profile']");

    private By profilePageHeader =
            By.xpath("//span[text()='Profile']");

    // ===== Constructor =====
    public PomOpenProfile(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ===== Business Method =====
    public boolean openProfilePage() {

        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewProfileLink)).click();

        // Validation: profile page opened
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(profilePageHeader)
        ).isDisplayed();
    }
}
