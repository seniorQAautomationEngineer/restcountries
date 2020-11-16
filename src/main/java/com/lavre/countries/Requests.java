package com.lavre.countries;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.Optional;



public class Requests {
    static String baseURI = "https://restcountries.eu";


    public static Optional<String> getCapitalByCountryCode(String code) {
        if (code.length() < 2 || code.length() > 3) {
            throw new IllegalArgumentException("Country code must be 2 or 3 characters. Your country code is wrong: " + code);
        }
        String endpoint = "/rest/v2/alpha/" + code;
        Response response = RestAssured.when().get(baseURI + endpoint);
       // response.prettyPrint();
        int responseCode = response.getStatusCode();
        System.out.println("Response code: " + responseCode);
        String json = response.getBody().asString();
        if (responseCode == 404) {
            return Optional.empty();
        }
        if (responseCode == 400) {
            throw new IllegalArgumentException("Bad request. Input is not correct!");
        }
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        return Optional.of(JsonPath.read(document, "$.capital"));
    }

    public static Optional<String> getCapitalByCountryName(String countryName) {
        String endpoint = "/rest/v2/name/" + countryName;
        Response response = RestAssured.when().get(baseURI + endpoint);
       // response.prettyPrint();
        int responseCode = response.getStatusCode();
        System.out.println("Response code: " + responseCode);
        String json = response.getBody().asString();
        if (responseCode == 404) {
            return Optional.empty();
        }
        if (responseCode == 400) {
            throw new IllegalArgumentException("Bad request. Input is not correct!");
        }
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        return Optional.of(JsonPath.read(document, "$[0].capital"));
    }


}
