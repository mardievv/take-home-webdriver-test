package com.academy.techcenture;

import com.academy.techcenture.pages.Dropdown;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest{

    @Test
    public void DropdownTestCase(){
        Dropdown dropdown = new Dropdown(driver,softAssert);
        dropdown.verifyDropDownMenu();
    }
}
