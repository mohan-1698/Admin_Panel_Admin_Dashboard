package com.srm.hackathon.adminpanel.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.srm.hackathon.adminpanel.base.BasePage;

public class TablePage extends BasePage {

    // ================= NAVIGATION =================

    @FindBy(xpath = "//span[text()='Apps']")
    private WebElement appsMenu;

    @FindBy(linkText = "HTML Table Generator")
    private WebElement tableGeneratorLink;

    // ================= TABLE =================

    @FindBy(xpath = "//table[@id='dynamictable']//th")
    private List<WebElement> headers;

    @FindBy(xpath = "//table[@id='dynamictable']//tr")
    private List<WebElement> rows;

    // ================= NAVIGATION =================

    public void navigateToTablePage() {
        click(appsMenu);
        click(tableGeneratorLink);
    }

    // ================= VALIDATIONS =================

    public boolean areHeadersCorrect() {
        return headers.size() >= 2 &&
               headers.get(0).getText().equalsIgnoreCase("name") &&
               headers.get(1).getText().equalsIgnoreCase("age");
    }

    public boolean isRowDataPresent(String value) {
        return rows.stream().anyMatch(row -> row.getText().contains(value));
    }
}