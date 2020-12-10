package com.automationpractice.tests;

import com.automationpractice.tests.base.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    /* Implementation of MS_UM_LOG_1 test case
    "Log in to the account with correct email and password"
     */
    @Test(invocationCount = 3)
    public void testLoginWithCorrectData() {
        var email = "test@testuser.pl";
        var password = "Test123";

        var signInPage = homePage.clickSignInButton();
        signInPage.signInInputEmail(email);
        signInPage.signInInputPassword(password);
        var myAccountPage = signInPage.clickSignInButton();

        assertThat(myAccountPage.getTitle()).isEqualTo("My account - My Store");
    }
}
