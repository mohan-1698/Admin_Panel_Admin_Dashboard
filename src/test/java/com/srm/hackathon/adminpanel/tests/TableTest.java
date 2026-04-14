package com.srm.hackathon.adminpanel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.adminpanel.base.BaseTest;
import com.srm.hackathon.adminpanel.pages.TablePage;

public class TableTest extends BaseTest {

    @Test
    public void testTableHeaders() {

        TablePage page = new TablePage();
        page.navigateToTablePage();

        Assert.assertTrue(
                page.areHeadersCorrect(),
                "Table headers are incorrect"
        );
    }

    @Test
    public void testInitialTableData() {

        TablePage page = new TablePage();
        page.navigateToTablePage();

        Assert.assertTrue(page.isRowDataPresent("Bob"), "Bob not found");
        Assert.assertTrue(page.isRowDataPresent("George"), "George not found");
    }
}