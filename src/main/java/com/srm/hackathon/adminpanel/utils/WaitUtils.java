package com.srm.hackathon.adminpanel.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.srm.hackathon.adminpanel.factory.DriverFactory;

public class WaitUtils {

    // ✅ Always fetch driver dynamically (ThreadLocal safe)
    private static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public static WebElement waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(
                getDriver(),
                Duration.ofSeconds(ConfigReader.getTimeout())
        );
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(
                getDriver(),
                Duration.ofSeconds(ConfigReader.getTimeout())
        );
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public static boolean waitForUrlContains(String partialUrl) {

        WebDriverWait wait = new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(ConfigReader.getTimeout())
        );

        return wait.until(ExpectedConditions.urlContains(partialUrl));
    }
}