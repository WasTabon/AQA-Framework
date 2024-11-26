package com.ultimateqa.tests;

import com.ultimateqa.pages.HomePage;
import com.ultimateqa.pages.PracticePage;
import com.ultimateqa.drivers.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticePageTest {

    private WebDriver driver;
    private HomePage homePage;
    private PracticePage practicePage;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        DriverPool.initializeDriver(browser);
        driver = DriverPool.getDriver();
        driver.get("https://ultimateqa.com/");
        homePage = new HomePage(driver);
        practicePage = new PracticePage(driver);
    }

    @Test
    public void verifyPracticePageNavigation() {
        homePage.clickPracticeLink();
        String heading = practicePage.getHeadingText();
        Assert.assertTrue(heading.contains("Practice"), "Heading is incorrect!");
    }

    @Test(dataProvider = "formInputData", dataProviderClass = DataProviders.class)
    public void testFormSubmission(String name, String description) {
        homePage.clickPracticeLink();
        practicePage.fillForm(name);
        practicePage.clickSubmit();
        System.out.println("Test Description: " + description);
    }

    @Test(dataProvider = "navigationLinks", dataProviderClass = DataProviders.class)
    public void testNavigationLinks(String linkText, String expectedTitle) {
        homePage.clickLinkByText(linkText);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
    }


    @AfterClass
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
