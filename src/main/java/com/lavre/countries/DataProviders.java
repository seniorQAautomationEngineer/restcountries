package com.lavre.countries;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "countryCodePositiveInput")
    public static Object[][] countryCodePositiveInput() {
        return new Object[][]{
                {"dz"},
                {"asm"},
                {"aia"},
                {"zwe"},
                {"wlf"},
        };
    }

    @DataProvider(name = "countryCodeNegativeInput")
    public static Object[][] countryCodeNegativeInput() {
        return new Object[][]{
                {"16"},
                {"$%^"},
                {"hhh"},
                {"1&"},
                {"1A"},
                {"*A"},
        };
    }

    @DataProvider(name = "countryCodeNegativeInputForException")
    public static Object[][] countryCodeNegativeInputForException() {
        return new Object[][]{
                {"1234"},
                {"1"},
                {"a"},
                {"&"},

        };
    }

    @DataProvider(name = "countryNamePositiveInput")
    public static Object[][] countryNamePositiveInput() {
        return new Object[][]{

                {"eesti"},
                {"aland"},
                {"dzayer"},
                {"hayastan"},

        };
    }

    @DataProvider(name = "countryNameNegativeInput")
    public static Object[][] countryNameNegativeInput() {
        return new Object[][]{

                {"%&@*"},
                {"1"},
                {"1234"},
                {"lldldl"},
                {"3939Nnsnsn"},

        };
    }
}
