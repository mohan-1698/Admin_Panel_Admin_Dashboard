package com.srm.hackathon.adminpanel.base;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.srm.hackathon.adminpanel.factory.DriverFactory;
import com.srm.hackathon.adminpanel.utils.WaitUtils;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        scrollToElement(element);
        try {
            WaitUtils.waitForElementClickable(element).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }

    protected void type(WebElement element, String value) {
        WebElement el = WaitUtils.waitForElementVisible(element);
        el.clear();
        el.sendKeys(value);
    }

    protected String getText(WebElement element) {
        return WaitUtils.waitForElementVisible(element).getText();
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }
    
    protected Alert waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}