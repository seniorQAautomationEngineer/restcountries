package com.lavre.countries.tests;


import com.lavre.countries.DataProviders;
import com.lavre.countries.Requests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CountriesTests {


    @Test(dataProvider = "countryCodePositiveInput", dataProviderClass = DataProviders.class, priority = 1)
    public void positiveTestsForCountryCode(String code){
        Assert.assertTrue(Requests.getCapitalByCountryCode(code).isPresent());
    }

    @Test(dataProvider = "countryCodeNegativeInput", dataProviderClass = DataProviders.class, priority = 2)
    public void negativeTestsForCountryCode(String code){
        Assert.assertFalse(Requests.getCapitalByCountryCode(code).isPresent());
    }


    @Test(dataProvider = "countryCodeNegativeInputForException", dataProviderClass = DataProviders.class, priority = 2)
    public void negativeTestsForCountryCodeWithException(String code) {
        Assert.assertThrows(IllegalArgumentException.class, () -> Requests.getCapitalByCountryCode(code));

    }

    @Test(dataProvider = "countryNamePositiveInput", dataProviderClass = DataProviders.class, priority = 3)
    public void positiveTestsForCountryName(String countryName){
        Assert.assertTrue(Requests.getCapitalByCountryName(countryName).isPresent());
    }



    @Test(dataProvider = "countryNameNegativeInput", dataProviderClass = DataProviders.class, priority = 4)
    public void negativeTestsForCountryName(String countryName){
        Assert.assertFalse(Requests.getCapitalByCountryName(countryName).isPresent());
    }

}
