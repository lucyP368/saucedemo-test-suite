package com.lucyP368;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lucyP368.pages.LoginPage;

public class SanityTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void sanityTest() {

        driver.get("https://saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertNotNull(loginPage);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    
}
