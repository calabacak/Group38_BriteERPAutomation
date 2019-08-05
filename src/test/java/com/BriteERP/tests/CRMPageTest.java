package com.BriteERP.tests;

import com.BriteERP.pages.CRMPage;
import com.BriteERP.pages.LoginPage;
import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.*;

public class CRMPageTest extends TestBase {

    @BeforeMethod
    public void setUpMethod2() {

        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void checkItemPrice() {
        LoginPage loginPage = new LoginPage();
        loginPage.successfulllogIn();

        CRMPage crmPage = new CRMPage();

        crmPage.CRMTab.click();
        crmPage.ListButton.click();

        String actualItemName=crmPage.newBook.getText();

        int actualItemPrice= Integer.parseInt(crmPage.newBookPrice.getText().substring(0,crmPage.newBookPrice.getText().length()-3));

        crmPage.PivotButton.click();
        crmPage.newOppButton.click();
        crmPage.opportunity.click();

        String actualItemName2=crmPage.newBook2.getText();
        int actualItemPrice2= Integer.parseInt(crmPage.newBookPrice2.getText().substring(0,crmPage.newBookPrice2.getText().length()-3));

        Assert.assertEquals(actualItemName,actualItemName2);
        Assert.assertEquals(actualItemPrice,actualItemPrice2);

    }

    @Test
    public void checkSumOfPivot() {
        LoginPage loginPage = new LoginPage();
        loginPage.successfulllogIn();

        CRMPage crmPage = new CRMPage();

        crmPage.CRMTab.click();
        crmPage.ListButton.click();

        String actualItemName=crmPage.newBook.getText();

        int actualItemPrice= Integer.parseInt(crmPage.newBookPrice.getText().substring(0,crmPage.newBookPrice.getText().length()-3));

        crmPage.PivotButton.click();
        crmPage.newOppButton.click();
        crmPage.opportunity.click();

        String actualItemName2=crmPage.newBook2.getText();
        int actualItemPrice2= Integer.parseInt(crmPage.newBookPrice2.getText().substring(0,crmPage.newBookPrice2.getText().length()-3));

        Assert.assertEquals(actualItemName,actualItemName2);
        Assert.assertEquals(actualItemPrice,actualItemPrice2);

        List <String> listOfItemPricesStr= new ArrayList<>();

        for(WebElement w : crmPage.expectedRevenueCol){
            listOfItemPricesStr.add(w.getText().substring(0,w.getText().length()-3).replace(",",""));
        }
        List<Integer> listOfItemPricesInt = new ArrayList<>();
        for(int i=0; i<listOfItemPricesStr.size(); i++){
            listOfItemPricesInt.add(Integer.parseInt(listOfItemPricesStr.get(i)));
            //
        }
        int sumAll=0;
        for(int i=2; i<listOfItemPricesInt.size(); i++){
            sumAll+=listOfItemPricesInt.get(i);
        }

        String totalstr= crmPage.total.getText();
        int totalint = Integer.parseInt(totalstr.substring(0,totalstr.length()-3).replace(",",""));

        Assert.assertEquals(sumAll,totalint);


    }

}
