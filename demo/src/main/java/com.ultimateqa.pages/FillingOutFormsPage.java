package com.ultimateqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillingOutFormsPage extends BasePage {

    @FindBy(id = "et_pb_contact_name_0")
    private WebElement nameField;

    @FindBy(id = "et_pb_contact_message_0")
    private WebElement messageField;

    @FindBy(css = ".et_pb_contact_submit")
    private WebElement submitButton;

    @FindBy(css = ".et-pb-contact-message > p")
    private WebElement confirmationMessage;

    public FillingOutFormsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get("https://ultimateqa.com/filling-out-forms/");
    }

    public void fillForm(String name, String message) {
        nameField.sendKeys(name);
        messageField.sendKeys(message);
    }

    public String submitForm() {
        submitButton.click();
        return confirmationMessage.getText();
    }
}
