package com.BriteERP.tests;

import com.BriteERP.pages.LoginPage;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @BeforeMethod
    public void setUpMethod2() {

        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void positiveUsernameAndPasswordTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.successfulllogIn();
        Assert.assertEquals(driver.getCurrentUrl(), "http://54.148.96.210/web?#menu_id=115&action=120&active_id=channel_inbox");
    }
    @Test
    public void negativeUsernameAndPasswordTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.invalidlogIn();
        Assert.assertTrue(loginPage.alert.getText().contains("Wrong login/password"));
    }
}