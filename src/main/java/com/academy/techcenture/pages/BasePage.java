package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected SoftAssert softAssert;

    protected WebDriverWait wait;

    protected Actions actions;


    public BasePage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        actions = new Actions(this.driver);
        PageFactory.initElements(driver,this);
    }

}
