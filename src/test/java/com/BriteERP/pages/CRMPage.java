package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CRMPage {

    public CRMPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "(//span[@class='oe_menu_text'])[5]")
    public WebElement CRMTab;

    @FindBy(xpath = "//button[@data-original-title='List']")
    public WebElement ListButton;


    @FindBy(xpath = "//table/tbody/tr[3]/td[3]")
    public WebElement newBook;

    @FindBy(xpath = "//table/tbody/tr[3]/td[9]")
    public WebElement newBookPrice;

    @FindBy(xpath = "//button[@data-original-title='Pivot']")
    public WebElement PivotButton;

    @FindBy(xpath = "//td[@class='o_pivot_header_cell_closed']")
    public WebElement newOppButton;

    @FindBy(xpath = "//a[contains(text(),'Opportunity')]")
    public WebElement opportunity;

    @FindBy(xpath = "//table/tbody/tr[7]/td[1]")
    public WebElement newBook2;

    @FindBy(xpath = "//table/tbody/tr[7]/td[2]")
    public WebElement newBookPrice2;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> expectedRevenueCol;

    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    public WebElement total;









}
