package com.lucyP368.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    private static final By inventoryBy = By.id("inventory_container");

    public HomePage(WebDriver driver) {
        super(driver, List.of(inventoryBy));
    }
    
}
