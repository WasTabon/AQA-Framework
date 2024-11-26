package com.ultimateqa.tests;

import com.ultimateqa.drivers.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        DriverPool.initializeDriver(browser);
        driver = DriverPool.getDriver();
        driver.get("https://ultimateqa.com/");
    }

    @AfterClass
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
