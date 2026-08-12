package com.lucyP368.pages;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver, List<By> expectedBys) {
        this.driver = driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (By expectedBy : expectedBys) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(expectedBy));
            } catch (TimeoutException e) {
                throw new IllegalStateException("Expected to be on " + this.getClass().getSimpleName() + ", but element not found: " + expectedBy);
            }
        }


    }

}
