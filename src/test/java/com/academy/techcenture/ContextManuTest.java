package com.academy.techcenture;

import com.academy.techcenture.pages.ContextManu;
import org.testng.annotations.Test;

public class ContextManuTest extends BaseTest{

    @Test
    public void ContextManuTestCase(){
        ContextManu contextManu = new ContextManu(driver,softAssert);
        contextManu.ContextManuActions();
    }
}
