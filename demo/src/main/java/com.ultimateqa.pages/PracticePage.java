
package com.ultimateqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticePage {

    private WebDriver driver;

    private By heading = By.tagName("h1");
    private By formInput = By.id("et_pb_contact_name_0");
    private By submitButton = By.xpath("//button[@name='et_builder_submit_button']");

    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public void fillForm(String name) {
        driver.findElement(formInput).sendKeys(name);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}
