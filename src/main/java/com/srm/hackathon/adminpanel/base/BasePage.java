package com.srm.hackathon.adminpanel.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.srm.hackathon.adminpanel.factory.DriverFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Common reusable methods

    protected void click(WebElement element) {
        element.click();
    }

    protected void type(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    protected String getText(WebElement element) {
        return element.getText();
    }
}