package com.ultimateqa.pages;

import com.ultimateqa.helpers.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    private ElementActions actions;

    @FindBy(linkText = "Practice")
    private WebElement practiceLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickPracticeLink() {
        actions.click(practiceLink);
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public void clickLinkByText(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        actions.click(link);
    }

}
