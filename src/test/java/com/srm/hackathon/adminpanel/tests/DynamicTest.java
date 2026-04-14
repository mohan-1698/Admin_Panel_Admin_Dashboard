package com.srm.hackathon.adminpanel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.adminpanel.base.BaseTest;
import com.srm.hackathon.adminpanel.pages.DynamicPage;
import com.srm.hackathon.adminpanel.pages.FormPage;
import com.srm.hackathon.adminpanel.utils.WaitUtils;

public class DynamicTest extends BaseTest {

    // ================= TEST 1 =================
    // Hidden → Visible + Dynamic Interaction

    @Test
    public void testDynamicButtonsFlow() {

        DynamicPage page = new DynamicPage();

        page.navigateToDynamicButtonsPage();

        page.clickStart();        // button00

        page.clickButtonOne();   // button01 (dynamic)
        page.clickButtonTwo();   // button02 (dynamic)
        page.clickButtonThree(); // button03 (dynamic)

        String result = page.getResultMessage();

        Assert.assertEquals(
                result,
                "All Buttons Clicked",
                "Dynamic button flow failed"
        );
    }

    // ================= TEST 2 =================
    // Verify final result only

    @Test
    public void testDynamicResultVerification() {

        DynamicPage page = new DynamicPage();

        page.navigateToDynamicButtonsPage();

        page.clickStart();
        page.clickButtonOne();
        page.clickButtonTwo();
        page.clickButtonThree();

        Assert.assertTrue(
                page.getResultMessage().contains("All Buttons Clicked"),
                "Result message not displayed correctly"
        );
    }

    // ================= TEST 3 =================
    // Redirect validation (from another module)

    @Test
    public void testRedirectValidation() {

        FormPage formPage = new FormPage();

        formPage.navigateToHtmlForm();

        Assert.assertTrue(
                WaitUtils.waitForUrlContains("html-form"),
                "Redirect URL not matched"
        );
    }
}