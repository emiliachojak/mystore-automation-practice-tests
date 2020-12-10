package com.automationpractice.tests.base;

import com.automationpractice.pages.HomePage;
import com.automationpractice.tests.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", TestConfig.DRIVER_PATH.configValue());
        driver = new ChromeDriver();
        driver.get(TestConfig.SITE_URL.configValue());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}