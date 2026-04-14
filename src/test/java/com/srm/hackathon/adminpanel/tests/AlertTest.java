package com.srm.hackathon.adminpanel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.adminpanel.base.BaseTest;
import com.srm.hackathon.adminpanel.pages.AlertPage;

public class AlertTest extends BaseTest {

    // ================= TEST 1 =================
    // Alert → Accept

    @Test
    public void testSimpleAlert() {

        AlertPage page = new AlertPage();

        page.navigateToAlertsPage();

        page.clickAlertButton();
        page.acceptAlert();

        Assert.assertTrue(
                page.getAlertResult().contains("You triggered and handled the alert dialog")
        );
    }

    // ================= TEST 2 =================
    // Confirm → Accept

    @Test
    public void testConfirmAccept() {

        AlertPage page = new AlertPage();

        page.navigateToAlertsPage();

        page.clickConfirmButton();
        page.acceptAlert();

        Assert.assertTrue(
                page.getConfirmResult().contains("You clicked OK")
        );
    }

    // ================= TEST 3 =================
    // Confirm → Dismiss

    @Test
    public void testConfirmDismiss() {

        AlertPage page = new AlertPage();

        page.navigateToAlertsPage();

        page.clickConfirmButton();
        page.dismissAlert();

        Assert.assertTrue(
                page.getConfirmResult().contains("You clicked Cancel")
        );
    }

    // ================= TEST 4 =================
    // Prompt

    @Test
    public void testPrompt() {

        AlertPage page = new AlertPage();

        page.navigateToAlertsPage();

        page.clickPromptButton();
        page.enterPromptText("Mickey");

        Assert.assertTrue(
                page.getPromptResult().contains("Mickey")
        );
    }
}