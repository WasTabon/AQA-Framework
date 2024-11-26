package com.ultimateqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationExercisesPage extends BasePage {

    @FindBy(id = "tab1")
    private WebElement tab1;

    @FindBy(id = "tab1-content")
    private WebElement tab1Content;

    public AutomationExercisesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get("https://ultimateqa.com/automation/");
    }

    public void clickTab(String tabName) {
        if (tabName.equalsIgnoreCase("Tab 1")) {
            tab1.click();
        }
    }

    public boolean isTabContentDisplayed(String expectedContent) {
        return tab1Content.getText().contains(expectedContent);
    }
}
