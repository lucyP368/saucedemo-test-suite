package com.lucyP368.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {


    private static final By usernameBy = By.id("user-name");
    private static final By passwordBy = By.id("password");
    private static final By loginBy = By.id("login-button");

    private static final By errorBy = By.className("error-message-container");


    public LoginPage(WebDriver driver) {
        super(driver, List.of(usernameBy, passwordBy, loginBy));
    }

    public Page login(String username, String password) {
        WebElement usernameField = this.driver.findElement(usernameBy);
        WebElement passwordField = this.driver.findElement(passwordBy);
        WebElement loginButton = this.driver.findElement(loginBy);

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        try {
            return new HomePage(this.driver);
        } catch (IllegalStateException e) {
            return this;
        }
    }

    public String getErrorString() {
        WebElement errorContainer = this.driver.findElement(errorBy);
        return errorContainer.getText();
    }
}
