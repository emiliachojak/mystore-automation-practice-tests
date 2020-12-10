package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends AbstractPage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}