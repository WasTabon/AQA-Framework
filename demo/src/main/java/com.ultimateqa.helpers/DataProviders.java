package com.ultimateqa.helpers;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "formInputData")
    public Object[][] provideFormInputData() {
        return new Object[][]{
            {"John Doe", "Valid input test"},
            {"", "Empty input test"},
            {"1234567890", "Numeric input test"},
            {"!@#$%^&*()", "Special character input test"}
        };
    }

    @DataProvider(name = "navigationLinks")
    public Object[][] provideNavigationLinks() {
        return new Object[][]{
            {"Practice", "Ultimate QA – Practice"},
            {"Courses", "Ultimate QA – Courses"},
            {"Automation Exercises", "Ultimate QA – Automation Exercises"}
        };
    }
}
