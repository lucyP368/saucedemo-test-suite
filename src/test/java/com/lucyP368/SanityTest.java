package com.lucyP368;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lucyP368.pages.HomePage;
import com.lucyP368.pages.LoginPage;
import com.lucyP368.pages.Page;

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


    @Test
    public void correctLoginTest() {
        driver.get("https://saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        Page homePage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(homePage instanceof HomePage);
    }

    @Test
    public void incorrectLoginTest() {
        driver.get("https://saucedemo.com");
        LoginPage loginPage = new LoginPage(driver);
        Page page = loginPage.login("invalid_user", "secret_sauce");
        if (page instanceof LoginPage unLoggedInPage) {
            Assert.assertEquals(unLoggedInPage.getErrorString(), "Epic sadface: Username and password do not match any user in this service");
        }
    }

    

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    
}
