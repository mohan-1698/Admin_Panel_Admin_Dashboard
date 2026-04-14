package com.srm.hackathon.adminpanel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.adminpanel.base.BaseTest;
import com.srm.hackathon.adminpanel.pages.FormPage;

public class FormTest extends BaseTest {

    // ================= TEST 1 =================
    // Valid Form Submission + Full Verification

    @Test
    public void testValidFormSubmission() {

        FormPage formPage = new FormPage();

        formPage.navigateToHtmlForm();

        formPage.fillTextFields("Mickey", "pass123", "Test comment");

        formPage.selectCheckboxByIndex(0);   // cb1
        formPage.selectRadioByIndex(2);      // rd3
        formPage.selectDropdownByValue("dd4");

        formPage.clickSubmit();

        // 🔥 Assertions
        Assert.assertEquals(formPage.getResultUsername(), "Mickey");
        Assert.assertEquals(formPage.getResultPassword(), "pass123");
        Assert.assertTrue(formPage.getResultComments().contains("Test comment"));

        Assert.assertEquals(formPage.getResultCheckbox(), "cb1");
        Assert.assertEquals(formPage.getResultRadio(), "rd3");
        Assert.assertEquals(formPage.getResultDropdown(), "dd4");
    }

    // ================= TEST 2 =================
    // Dropdown Verification

    @Test
    public void testDropdownSelection() {

        FormPage formPage = new FormPage();

        formPage.navigateToHtmlForm();

        formPage.selectDropdownByValue("dd2");

        formPage.clickSubmit();

        Assert.assertEquals(formPage.getResultDropdown(), "dd2");
    }

    // ================= TEST 3 =================
    // Checkbox + Radio Verification

    @Test
    public void testCheckboxAndRadio() {

        FormPage formPage = new FormPage();

        formPage.navigateToHtmlForm();

        formPage.selectCheckboxByIndex(1); // cb2
        formPage.selectRadioByIndex(0);    // rd1

        formPage.clickSubmit();

        Assert.assertEquals(formPage.getResultCheckbox(), "cb2");
        Assert.assertEquals(formPage.getResultRadio(), "rd1");
    }

    // ================= TEST 4 =================
    // Empty Form Submission Validation

    @Test
    public void testEmptyFormSubmission() {

        FormPage formPage = new FormPage();

        formPage.navigateToHtmlForm();

        formPage.clickSubmit();

        // Default comment value appears
        Assert.assertTrue(
        	    formPage.getResultUsername().contains("No Value for username"),
        	    "Username empty validation failed"
        	);

        	Assert.assertTrue(
        	    formPage.getResultPassword().contains("No Value for password"),
        	    "Password empty validation failed"
        	);

        	Assert.assertTrue(
        	    formPage.getResultComments().contains("Comments..."),
        	    "Comments default value failed"
        	);
    }
    
    @Test
    public void testInValidFormSubmission() {

        FormPage formPage = new FormPage();

        formPage.navigateToHtmlForm();

        formPage.fillTextFields("Mickey", "pass123", "Test comment");

        formPage.selectCheckboxByIndex(0);   // cb1
        formPage.selectRadioByIndex(2);      // rd3
        formPage.selectDropdownByValue("dd4");

        formPage.clickSubmit();

        // 🔥 Assertions
        Assert.assertEquals(formPage.getResultUsername(), "Mohan");
        Assert.assertEquals(formPage.getResultPassword(), "pass123");
        Assert.assertTrue(formPage.getResultComments().contains("Test comment"));

        Assert.assertEquals(formPage.getResultCheckbox(), "cb1");
        Assert.assertEquals(formPage.getResultRadio(), "rd3");
        Assert.assertEquals(formPage.getResultDropdown(), "dd4");
    }
}