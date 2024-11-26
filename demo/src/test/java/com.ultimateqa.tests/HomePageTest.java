package com.ultimateqa.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageTitle() {
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        assert pageTitle.contains("Ultimate QA");
    }

    @Test
    public void navigateToPracticePage() {
        driver.findElement(By.linkText("Practice")).click();
        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url);
        assert url.contains("practice");
    }
}
