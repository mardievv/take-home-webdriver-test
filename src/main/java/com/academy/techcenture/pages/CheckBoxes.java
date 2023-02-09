package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.academy.techcenture.config.ConfigReader.getProperties;

public class CheckBoxes extends BasePage {

    public CheckBoxes(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//div[@id='content']//div/h3")
    private WebElement checkBoxesLogo;

    @FindBy(xpath = "//form[@id='checkboxes']/input")
    private List<WebElement> checkboxesInput;



    /**
     * This method contains all methods and runs
     */
    public void checkAndUncheckBoxes() {
        navigateToCheckboxesPage();
        checkbox();
        unCheckbox();
    }


    /**
     * This method will navigate to Checkboxes page
     */
    private void navigateToCheckboxesPage() {
        driver.get(getProperties("url")+"/checkboxes");
    }


    /**
     * This method will click all unchecked checkboxes and verify If all checkboxes are checked
     */
    private void checkbox(){
        softAssert.assertEquals(checkBoxesLogo.getText().trim(),"Checkboxes", "Checkboxes logo do not match");
        for (WebElement checkbox : checkboxesInput) {
            if (!checkbox.isSelected())
                checkbox.click();
            softAssert.assertTrue(checkbox.isSelected(), "Checkbox is not selected");
        }
    }


    /**
     * This method will click all checked checkboxes and verify If all checkboxes are unchecked
     */
    private void unCheckbox(){
        softAssert.assertEquals(checkBoxesLogo.getText().trim(),"Checkboxes", "Checkboxes logo do not match");
        for (WebElement checkbox : checkboxesInput) {
            if (checkbox.isSelected())
                checkbox.click();
            softAssert.assertTrue(!checkbox.isSelected(), "Checkbox is already selected");
        }
    }

}
