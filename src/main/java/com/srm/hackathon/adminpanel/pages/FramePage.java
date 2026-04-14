package com.srm.hackathon.adminpanel.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.srm.hackathon.adminpanel.base.BasePage;
import com.srm.hackathon.adminpanel.utils.WaitUtils;

public class FramePage extends BasePage {

    // ================= NAVIGATION =================

    @FindBy(id = "m-pages")
    private WebElement pagesLink;

    @FindBy(linkText = "Embedded Content")
    private WebElement embeddedContentLink;

    @FindBy(linkText = "iFrames")
    private WebElement iframeLink;

    @FindBy(linkText = "iFrames With External Site Content")
    private WebElement externalIframeLink;

    // ================= IFRAMES =================

    @FindBy(tagName = "iframe")
    private List<WebElement> iframes;

    @FindBy(id = "urlSelect")
    private WebElement urlDropdown;

    @FindBy(id = "contentFrame")
    private WebElement contentFrame;

    // ================= NAVIGATION METHODS =================

    public void navigateToIframesPage() {
        click(pagesLink);
        click(embeddedContentLink);
        click(iframeLink);
    }

    public void navigateToExternalIframePage() {
        click(pagesLink);
        click(embeddedContentLink);
        click(externalIframeLink);
    }

    // ================= FRAME SWITCH =================

    public void switchToLeftFrame() {
        WaitUtils.waitForElementVisible(iframes.get(0));
        driver.switchTo().frame(iframes.get(0));
    }

    public void switchToRightFrame() {
        WaitUtils.waitForElementVisible(iframes.get(1));
        driver.switchTo().frame(iframes.get(1));
    }

    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }

    // ================= INTERACTION =================

    public void clickListItem(int index) {
        WebElement item = driver.findElement(By.id("iframe" + index));
        click(item);
    }

    public String getListItemText(int index) {
        return driver.findElement(By.id("iframe" + index)).getText();
    }

    public String getMainHeading() {
        return driver.findElement(By.tagName("h1")).getText();
    }

    // ================= EXTERNAL IFRAME =================

    public void selectEvilTesterSite() {
        Select select = new Select(urlDropdown);
        select.selectByVisibleText("Evil Tester");
    }

    public boolean isIframeLoaded() {
        return contentFrame.isDisplayed()
                && contentFrame.getAttribute("src") != null
                && !contentFrame.getAttribute("src").isEmpty();
    }
}