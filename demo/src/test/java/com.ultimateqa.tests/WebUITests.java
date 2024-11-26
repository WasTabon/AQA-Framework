package com.ultimateqa.tests;

import com.ultimateqa.pages.AutomationExercisesPage;
import com.ultimateqa.pages.BrokenLinksPage;
import com.ultimateqa.pages.FillingOutFormsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebUITests extends BaseTest {

    @Test(description = "Verify form submission", groups = {"web-ui"})
    public void verifyFormSubmission() {
        FillingOutFormsPage formsPage = new FillingOutFormsPage(driver);
        formsPage.navigateTo();
        formsPage.fillForm("John Doe", "This is a test comment.");
        String confirmationMessage = formsPage.submitForm();
        Assert.assertEquals(confirmationMessage, "Form filled out successfully", "Form submission failed!");
    }

    @Test(description = "Verify tab click on Automation Exercises page", groups = {"web-ui"})
    public void verifyTabClick() {
        AutomationExercisesPage exercisesPage = new AutomationExercisesPage(driver);
        exercisesPage.navigateTo();
        exercisesPage.clickTab("Tab 1");
        Assert.assertTrue(exercisesPage.isTabContentDisplayed("Tab 1 content"), "Tab content is not displayed!");
    }

    @Test(description = "Verify broken links page", groups = {"web-ui"})
    public void verifyBrokenLinks() {
        BrokenLinksPage brokenLinksPage = new BrokenLinksPage(driver);
        brokenLinksPage.navigateTo();
        int brokenLinkCount = brokenLinksPage.checkBrokenLinks();
        Assert.assertEquals(brokenLinkCount, 0, "There are broken links on the page!");
    }
}
