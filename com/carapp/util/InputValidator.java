package com.carapp.util;

import java.util.Scanner;

public class InputValidator {
    
    public static String getStringInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    public static int getIntInput(Scanner scanner, String prompt, int min, int max) {
        int value = 0;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                value = Integer.parseInt(input);
                
                if (value >= min && value <= max) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        
        return value;
    }
    
    public static double getDoubleInput(Scanner scanner, String prompt, double min, double max) {
        double value = 0;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                value = Double.parseDouble(input);
                
                if (value >= min && value <= max) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        
        return value;
    }
}