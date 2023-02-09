package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class ContextManu extends BasePage{

    public ContextManu(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }


    @FindBy(xpath = "//div[@id='content']/div/h3")
    private WebElement contextMenuLogo;

    @FindBy(id = "hot-spot")
    private WebElement box;

    public void ContextManuActions(){
        navigateToContextPage();
        checkAlertWindow();
    }


    private void checkAlertWindow(){
        softAssert.assertEquals(contextMenuLogo.getText().trim(),"Context Menu","Context manu logo does not match");
        actions.contextClick(box).build().perform();
        Alert alert = driver.switchTo().alert();
        softAssert.assertEquals(alert.getText(),"You selected a context menu","Alert message does not match");
        alert.accept();
        contextMenuLogo.click();
    }


    /**
     * This method will navigate to Context Manu page
     */
    private void navigateToContextPage(){
        driver.get(ConfigReader.getProperties("url")+"/context_menu");
    }

}
