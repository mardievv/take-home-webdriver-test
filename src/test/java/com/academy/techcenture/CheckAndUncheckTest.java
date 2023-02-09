package com.academy.techcenture;

import com.academy.techcenture.pages.CheckBoxes;
import org.testng.annotations.Test;

public class CheckAndUncheckTest extends BaseTest {

    @Test
    public void CheckAndUncheckTestCase(){
        CheckBoxes checkBoxes = new CheckBoxes(driver,softAssert);
        checkBoxes.checkAndUncheckBoxes();
    }
}
