package com.srm.hackathon.adminpanel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.adminpanel.base.BaseTest;
import com.srm.hackathon.adminpanel.pages.FramePage;

public class FrameTest extends BaseTest {

    // ================= TEST 1 =================
    // Switch to iframe and interact

    @Test
    public void testIframeInteraction() {

        FramePage page = new FramePage();

        page.navigateToIframesPage();

        page.switchToLeftFrame();

        page.clickListItem(5);

        String text = page.getListItemText(5);

        Assert.assertEquals(
                text,
                "iFrame List Item 5",
                "Incorrect item text inside iframe"
        );
    }

    // ================= TEST 2 =================
    // Verify text inside iframe

    @Test
    public void testIframeTextVerification() {

        FramePage page = new FramePage();

        page.navigateToIframesPage();

        page.switchToLeftFrame();

        String text = page.getListItemText(10);

        Assert.assertEquals(
                text,
                "iFrame List Item 10",
                "Iframe text verification failed"
        );
    }

    // ================= TEST 3 =================
    // Switch back to main page

    @Test
    public void testSwitchBackToMainPage() {

        FramePage page = new FramePage();

        page.navigateToIframesPage();

        page.switchToLeftFrame();

        page.switchToMainPage();

        Assert.assertTrue(
                page.getMainHeading().contains("iFrames"),
                "Failed to switch back to main page"
        );
    }

    // ================= TEST 4 =================
    // External iframe validation

    @Test
    public void testExternalIframeLoad() {

        FramePage page = new FramePage();

        page.navigateToExternalIframePage();

        page.selectEvilTesterSite();

        Assert.assertTrue(
                page.isIframeLoaded(),
                "External iframe not loaded properly"
        );
    }
}