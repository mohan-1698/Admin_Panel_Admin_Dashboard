package com.srm.hackathon.adminpanel.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.srm.hackathon.adminpanel.base.BaseTest;
import com.srm.hackathon.adminpanel.pages.FormPage;
import com.srm.hackathon.adminpanel.utils.ExcelUtil;

public class FormTest extends BaseTest {

    // ================= DATA PROVIDER =================

    @DataProvider(name = "formData")
    public Object[][] getData() {
        return ExcelUtil.getTestData("FormData");
    }

    // ================= TEST 1 =================
    // Data-driven Valid Form Submission

    @Test(dataProvider = "formData")
    public void testValidFormSubmission(String user, String pass, String comment,
                                        String checkboxIndex, String radioIndex, String dropdown) {

        FormPage formPage = new FormPage();

        formPage.navigateToHtmlForm();

        formPage.fillTextFields(user, pass, comment);

      

        int cbIndex = (int) Double.parseDouble(checkboxIndex);
        int rdIndex = (int) Double.parseDouble(radioIndex);

        formPage.selectCheckboxByIndex(cbIndex);
        formPage.selectRadioByIndex(rdIndex);

        formPage.selectDropdownByValue(dropdown);

        formPage.clickSubmit();

        // Assertions (dynamic)
        Assert.assertEquals(formPage.getResultUsername(), user);
        Assert.assertEquals(formPage.getResultPassword(), pass);
        Assert.assertTrue(formPage.getResultComments().contains(comment));
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
}