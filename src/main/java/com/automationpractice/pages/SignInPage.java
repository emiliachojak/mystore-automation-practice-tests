package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends AbstractPage {

    By createAnAccountEmailField = By.id("email_create");
    By createAnAccountButton = By.id("SubmitCreate");
    By SignInEmailField = By.id("email");
    By signInPasswordField = By.id("passwd");
    By signInButton = By.id("SubmitLogin");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void createAccountInputEmail(String email) {
        driver.findElement(createAnAccountEmailField).sendKeys(email);
    }

    /**
     * Registration form on the site is updated by JQuery with some extra fancy graphics, which creates staleness and interaction problems.
     * Temporary solve is to have an ugly thread sleep waiting for a JQuery to finish.
     *
     * @return
     */
    public CreateAnAccountPage clickCreateAnAccountButton() {
        driver.findElement(createAnAccountButton).click();
        waitForPageToLoad();
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong while waiting for page to load");
            e.printStackTrace();
        }
        return new CreateAnAccountPage(this.driver);
    }

    public void signInInputEmail(String email) {
        driver.findElement(SignInEmailField).sendKeys(email);
    }

    public void signInInputPassword(String password) {
        driver.findElement(signInPasswordField).sendKeys(password);
    }

    public MyAccountPage clickSignInButton() {
        driver.findElement(signInButton).click();
        waitForPageToLoad();
        return new MyAccountPage(this.driver);
    }
}