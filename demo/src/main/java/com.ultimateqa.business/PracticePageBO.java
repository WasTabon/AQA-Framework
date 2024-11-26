package com.ultimateqa.business;

import com.ultimateqa.pages.HomePage;
import com.ultimateqa.pages.PracticePage;
import org.openqa.selenium.WebDriver;

public class PracticePageBO {

    private WebDriver driver;
    private HomePage homePage;
    private PracticePage practicePage;

    public PracticePageBO(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.practicePage = new PracticePage(driver);
    }

    public void navigateToPracticePage() {
        homePage.clickPracticeLink();
    }

    public String getPracticePageHeading() {
        return practicePage.getHeadingText();
    }

    public void submitFormWithName(String name) {
        practicePage.fillForm(name);
        practicePage.clickSubmit();
    }
}
