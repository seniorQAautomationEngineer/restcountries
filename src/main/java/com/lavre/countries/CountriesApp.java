package com.lavre.countries;

import java.util.Optional;
import java.util.Scanner;

public class CountriesApp {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Find capital by country code. Please, type /code  and type 2 or 3 characters. For example: '/code co'");
        System.out.println("Find capital by country name. Please, type /country  and type name of country. For example: '/country eesti'");
        System.out.println("End program. Please, type /exit ");
        while (true) {
            System.out.println("Enter name of country or code or /exit from program");
            String input = scanner.nextLine();
            if (input.contains("/exit")) {
                break;
            } else if (input.startsWith("/code ")) {
                String code = input.split(" ")[1];
                executeCommandWithCountryCode(code);
            } else if (input.startsWith("/country ")) {
                String name = input.split(" ")[1];
                executeCommandWithCountryName(name);
            } else {
                System.out.println("Unknown command");
            }
        }
        System.out.println("Program is ended");
    }


    private static void executeCommandWithCountryName(String name) {
        try {
            Optional<String> capital = Requests.getCapitalByCountryName(name);
            if (capital.isPresent()) {
                System.out.println("Capital  of country: " + capital.get() + " for country name: " + name);
            } else {
                System.out.println("Country is not found. Country name is not correct: " + name);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to proceed with command: " + e.getMessage());
        }
    }


    private static void executeCommandWithCountryCode(String countryCode) {
        try {
            Optional<String> capital = Requests.getCapitalByCountryCode(countryCode);
            if (capital.isPresent()) {
                System.out.println("Capital  of country: " + capital.get() + " for country code: " + countryCode);
            } else {
                System.out.println("Country is not found. Country code is not correct: " + countryCode);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to proceed with command: " + e.getMessage());
        }
    }
}
