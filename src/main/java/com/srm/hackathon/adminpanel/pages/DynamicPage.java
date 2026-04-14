package com.srm.hackathon.adminpanel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.srm.hackathon.adminpanel.base.BasePage;
import com.srm.hackathon.adminpanel.utils.WaitUtils;

public class DynamicPage extends BasePage {

    // ================= NAVIGATION =================

    @FindBy(id = "m-challenges")
    private WebElement challengesLink;

    @FindBy(linkText = "Synchronization Challenges")
    private WebElement syncChallengesLink;

    @FindBy(linkText = "Dynamic Buttons 01")
    private WebElement dynamicButtonsLink;

    // ================= BUTTONS =================

    @FindBy(id = "button00")
    private WebElement startButton;

    @FindBy(id = "button01")
    private WebElement buttonOne;

    @FindBy(id = "button02")
    private WebElement buttonTwo;

    @FindBy(id = "button03")
    private WebElement buttonThree;

    @FindBy(id = "buttonmessage")
    private WebElement resultMessage;

    // ================= NAVIGATION METHOD =================

    public void navigateToDynamicButtonsPage() {
        click(challengesLink);
        click(syncChallengesLink);
        click(dynamicButtonsLink);
    }

    // ================= ACTIONS =================

    public void clickStart() {
        click(startButton);
    }

    public void clickButtonOne() {
        click(WaitUtils.waitForElementVisible(buttonOne));
    }

    public void clickButtonTwo() {
        click(WaitUtils.waitForElementVisible(buttonTwo));
    }

    public void clickButtonThree() {
        click(WaitUtils.waitForElementVisible(buttonThree));
    }

    public String getResultMessage() {
        return WaitUtils.waitForElementVisible(resultMessage).getText();
    }
}