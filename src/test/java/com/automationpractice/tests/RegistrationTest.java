package com.automationpractice.tests;

import com.automationpractice.tests.base.BaseTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends BaseTest {

    /*
    Implementation of MS_UM_REG_1 test case
    "Register a new account with correct personal data"
     */
    @Test(invocationCount = 3)
    public void testRegistrationWithCorrectData() {
        var formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        var currentDatetime = LocalDateTime.now().format(formatter);
        var email = "testmail" + currentDatetime + "@temporary-mail.net";
        var firstName = "Carrie";
        var lastName = "Burt";
        var password = "Pass1234";
        var addressFirstLine = "3816 Ferguson Street";
        var city = "New York";
        var state = "New York";
        var postcode = "10011";
        var country = "United States";
        var mobilePhoneNumber = "646-649-2392";
        var alias = "Test address";

        var signInPage = homePage.clickSignInButton();
        signInPage.createAccountInputEmail(email);
        var createAnAccountPage = signInPage.clickCreateAnAccountButton();

        createAnAccountPage.inputFirstName(firstName);
        createAnAccountPage.inputLastName(lastName);
        createAnAccountPage.inputPassword(password);
        createAnAccountPage.inputAddressFirstLine(addressFirstLine);
        createAnAccountPage.inputCity(city);
        createAnAccountPage.chooseStateFromDropdown(state);
        createAnAccountPage.inputPostcode(postcode);
        createAnAccountPage.chooseCountryFromDropdown(country);
        createAnAccountPage.inputMobilePhoneNumber(mobilePhoneNumber);
        createAnAccountPage.inputAddressAlias(alias);
        var myAccountPage = createAnAccountPage.clickRegisterButton();

        assertThat(myAccountPage.getTitle()).isEqualTo("My account - My Store");
    }
}
