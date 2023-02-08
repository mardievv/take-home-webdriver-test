package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import static com.academy.techcenture.config.ConfigReader.getProperties;

public class Login extends BasePage{

    public Login(WebDriver driver, SoftAssert softAssert){
        super(driver,softAssert);
    }


    @FindBy(xpath = "//div[@id='content']/div/h2")
    private WebElement loginLogo;

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='radius']")
    private WebElement loginBtn;

    @FindBy(id="flash")
    private WebElement incorrectLogInMsg;

    @FindBy(xpath = "//div[@id='flash-messages']/div")
    private WebElement logInSuccessMsg;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutLink;


    public void verifyLoginFunctionality(){
        navigateToLoginPage();
        positiveLogin();
        negativeLogin();
    }

    private void positiveLogin(){
        verifyLoginElements();
        enterUsername(getProperties("username"));
        enterPassword(getProperties("password"));
        clickOnLoginButton();
        softAssert.assertTrue(logInSuccessMsg.isDisplayed(),"Login success message is not displayed");
        softAssert.assertTrue(logoutLink.isEnabled() && logoutLink.isDisplayed(),"Logout link is not enabled");
        logoutLink.click();
    }

    private void negativeLogin(){
        navigateToLoginPage();
        verifyLoginElements();
        enterUsername("invalidUsername");
        enterPassword("invalidPassword");
        clickOnLoginButton();
        softAssert.assertTrue(incorrectLogInMsg.isDisplayed(),"Login incorrect message is not displayed");
    }

    private void navigateToLoginPage(){
        driver.get("http://localhost:7080/login");
        softAssert.assertEquals(driver.getTitle(),"The Internet","Titles do not match");
    }

    private void verifyLoginElements(){
        softAssert.assertEquals(loginLogo.getText().trim(),"Login Page","Login logo does not match");
        softAssert.assertTrue(usernameInput.isEnabled() && usernameInput.isDisplayed(),"Username input is not enabled");
        softAssert.assertTrue(passwordInput.isEnabled() && passwordInput.isDisplayed(),"Password input is not enabled");
        softAssert.assertTrue(loginBtn.isEnabled() && loginBtn.isDisplayed(),"Login button is not enabled");
    }

    private void clickOnLoginButton(){
        softAssert.assertTrue(loginBtn.isEnabled());
        loginBtn.click();
    }

    private void enterUsername(String username){
        usernameInput.sendKeys(username);
    }

    private void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

}
