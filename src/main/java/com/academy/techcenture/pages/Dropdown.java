package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.academy.techcenture.config.ConfigReader.getProperties;

public class Dropdown extends BasePage{

    public Dropdown(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    @FindBy(xpath = "//select[@id='dropdown']/option")
    private List<WebElement> options;

    public void verifyDropDownMenu(){
        navigateToDropdownPage();
        Select select = new Select(dropdown);
        for (int i = 1; i < options.size(); i++){
            select.selectByIndex(i);
            softAssert.assertTrue(options.get(i).isSelected(),options.get(i).getText()+" is not selected");
        }
    }

    private void navigateToDropdownPage(){
        driver.get(getProperties("url")+"/dropdown");
    }

}
