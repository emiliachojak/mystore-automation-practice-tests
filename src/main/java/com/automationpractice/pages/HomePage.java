package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    private final By signInButton = By.className("login");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignInPage clickSignInButton() {
        driver.findElement(signInButton).click();
        waitForPageToLoad();
        return new SignInPage(this.driver);
    }
}