package com.srm.hackathon.adminpanel.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.srm.hackathon.adminpanel.base.BasePage;

public class AlertPage extends BasePage {

    // ================= NAVIGATION =================

    @FindBy(id = "m-pages")
    private WebElement pagesLink;

    @FindBy(linkText = "Basics")
    private WebElement basicsLink;

    @FindBy(linkText = "Alerts - JavaScript")
    private WebElement alertsJsLink;

    // ================= BUTTONS =================

    @FindBy(id = "alertexamples")
    private WebElement alertBtn;

    @FindBy(id = "confirmexample")
    private WebElement confirmBtn;

    @FindBy(id = "promptexample")
    private WebElement promptBtn;

    // ================= RESULT TEXT =================

    @FindBy(id = "alertexplanation")
    private WebElement alertResult;

    @FindBy(id = "confirmexplanation")
    private WebElement confirmResult;

    @FindBy(id = "promptexplanation")
    private WebElement promptResult;

    // ================= NAVIGATION =================

    public void navigateToAlertsPage() {
        click(pagesLink);
        click(basicsLink);
        click(alertsJsLink);
    }

    // ================= ACTIONS =================

    public void clickAlertButton() {
        click(alertBtn);
    }

    public void clickConfirmButton() {
        click(confirmBtn);
    }

    public void clickPromptButton() {
        click(promptBtn);
    }

    // ================= ALERT HANDLING =================

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void enterPromptText(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    // ================= GET RESULTS =================

    public String getAlertResult() {
        return getText(alertResult);
    }

    public String getConfirmResult() {
        return getText(confirmResult);
    }

    public String getPromptResult() {
        return getText(promptResult);
    }
}