package com.ultimateqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksPage extends BasePage {

    public BrokenLinksPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.get("https://ultimateqa.com/broken-links/");
    }

    public int checkBrokenLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int brokenLinks = 0;

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    if (connection.getResponseCode() >= 400) {
                        brokenLinks++;
                    }
                } catch (Exception e) {
                    brokenLinks++;
                }
            }
        }
        return brokenLinks;
    }
}
