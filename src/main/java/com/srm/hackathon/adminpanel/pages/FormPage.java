package com.srm.hackathon.adminpanel.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.srm.hackathon.adminpanel.base.BasePage;

public class FormPage extends BasePage {

    // ================= NAVIGATION =================

    @FindBy(id = "m-pages")
    private WebElement pagesLink;

    @FindBy(linkText = "Forms")
    private WebElement formsLink;

    @FindBy(linkText = "HTML Form")
    private WebElement htmlFormLink;

    // ================= FORM ELEMENTS =================

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "comments")
    private WebElement comments;

    @FindBy(name = "checkboxes[]")
    private List<WebElement> checkboxes;

    @FindBy(name = "radioval")
    private List<WebElement> radioButtons;

    @FindBy(name = "dropdown")
    private WebElement dropdown;

    @FindBy(css = "input[type='submit']")
    private WebElement submitBtn;

    // ================= RESULT ELEMENTS =================

    // When value is present
    @FindBy(id = "_valueusername")
    private List<WebElement> resultUsernameValue;

    // When value is empty
    @FindBy(id = "_username")
    private WebElement resultUsernameContainer;
    
    @FindBy(id = "_valuepassword")
    private List<WebElement> resultPasswordValue;

    @FindBy(id = "_password")
    private WebElement resultPasswordContainer;

    @FindBy(id = "_valuecomments")
    private WebElement resultComments;

    @FindBy(id = "_valuecheckboxes0")
    private WebElement resultCheckbox;

    @FindBy(id = "_valueradioval")
    private WebElement resultRadio;

    @FindBy(id = "_valuedropdown")
    private WebElement resultDropdown;

    // ================= NAVIGATION METHOD =================

    public void navigateToHtmlForm() {
        click(pagesLink);
        click(formsLink);
        click(htmlFormLink);
    }

    // ================= FORM ACTIONS =================

    public void fillTextFields(String user, String pass, String comment) {
        type(username, user);
        type(password, pass);
        type(comments, comment);
    }

    public void selectCheckboxByIndex(int index) {
        if (!checkboxes.get(index).isSelected()) {
            click(checkboxes.get(index));
        }
    }

    public void selectRadioByIndex(int index) {
        click(radioButtons.get(index));
    }

    public void selectDropdownByValue(String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public void clickSubmit() {
        click(submitBtn);
    }
    


    // ================= RESULT METHODS =================

    public String getResultUsername() {
        try {
            if (resultUsernameValue.size() > 0) {
                return resultUsernameValue.get(0).getText();
            }
        } catch (Exception e) {
            // ignore
        }
        return resultUsernameContainer.getText();
    }

    public String getResultPassword() {
        try {
            if (resultPasswordValue.size() > 0) {
                return resultPasswordValue.get(0).getText();
            }
        } catch (Exception e) {
            // ignore
        }
        return resultPasswordContainer.getText();
    }

    public String getResultComments() {
        return getText(resultComments);
    }

    public String getResultCheckbox() {
        return getText(resultCheckbox);
    }

    public String getResultRadio() {
        return getText(resultRadio);
    }

    public String getResultDropdown() {
        return getText(resultDropdown);
    }
}