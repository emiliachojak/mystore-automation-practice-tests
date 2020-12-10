package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage extends AbstractPage {

    private final By firstNameField = By.id("customer_firstname");
    private final By lastNameField = By.id("customer_lastname");
    private final By passwordField = By.id("passwd");
    private final By addressFirstLineField = By.id("address1");
    private final By cityField = By.id("city");
    private final By stateDropdown = By.id("id_state");
    private final By postcodeField = By.id("postcode");
    private final By countryDropdown = By.id("id_country");
    private final By mobilePhoneField = By.id("phone_mobile");
    private final By addressAliasField = By.id("alias");
    private final By registerAccountButton = By.id("submitAccount");

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }

    public void inputFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void inputAddressFirstLine(String address) {
        driver.findElement(addressFirstLineField).sendKeys(address);
    }

    public void inputCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void chooseStateFromDropdown(String state) {
        var stateSelect = new Select(driver.findElement(stateDropdown));
        stateSelect.selectByVisibleText(state);
    }

    public void inputPostcode(String postcode) {
        driver.findElement(postcodeField).sendKeys(postcode);
    }

    public void chooseCountryFromDropdown(String country) {
        var citySelect = new Select(driver.findElement(countryDropdown));
        citySelect.selectByVisibleText(country);
    }

    public void inputMobilePhoneNumber(String mobilePhoneNumber) {
        driver.findElement(mobilePhoneField).sendKeys(mobilePhoneNumber);
    }

    public void inputAddressAlias(String alias) {
        driver.findElement(addressAliasField).clear();
        driver.findElement(addressAliasField).sendKeys(alias);
    }

    public MyAccountPage clickRegisterButton() {
        driver.findElement(registerAccountButton).click();
        waitForPageToLoad();
        return new MyAccountPage(this.driver);
    }
}
