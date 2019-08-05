package com.BriteERP.pages;

import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath="//*[text()='Sign in']")
    public WebElement SignIn;

    @FindBy(id="login")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement login;

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement alert;

    public  void successfulllogIn(){
        username.sendKeys(ConfigurationReader.get("username"));
        password.sendKeys(ConfigurationReader.get("password"));
        login.click();
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
    }

    public  void invalidlogIn(){
        username.sendKeys(ConfigurationReader.get("username"));
        password.sendKeys(ConfigurationReader.get("password").toUpperCase());
        login.click();
    }


}
