package com.ultimateqa.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class ElementActions {

    private WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element) {
        try {
            element.click();
            System.out.println("Clicked on element: " + element.toString());
        } catch (Exception e) {
            System.err.println("Unable to click on element: " + element.toString());
            throw e;
        }
    }

    public void sendKeys(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            System.out.println("Entered text: '" + text + "' into element: " + element.toString());
        } catch (Exception e) {
            System.err.println("Unable to send keys to element: " + element.toString());
            throw e;
        }
    }

    public String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            System.err.println("Unable to get text from element: " + element.toString());
            throw e;
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("Scrolled to element: " + element.toString());
        } catch (Exception e) {
            System.err.println("Unable to scroll to element: " + element.toString());
            throw e;
        }
    }
}
