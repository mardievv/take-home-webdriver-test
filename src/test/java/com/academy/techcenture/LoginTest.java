package com.academy.techcenture;

import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {




    @Test
    public void LoginTest(){
        Login login = new Login(driver,softAssert);
        login.verifyLoginFunctionality();
    }

}
