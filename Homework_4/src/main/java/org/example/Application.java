package org.example;

import java.util.Scanner;

public class Application {

    /**
     * The main method that serves as the entry point for the ConsoleCalculator program.
     * It prompts the user to input two integers and an operator, then performs the calculation
     * and prints the result.
     * Handles exceptions for invalid operators and division by zero.
     */

    public static void main(String[] args) {

        // Create an instance of ConsoleCalculator
        ConsoleCalculator consoleCalculator = new ConsoleCalculator();

        // Create a Scanner object for reading user input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first value
        System.out.println("Enter first value:  ");
        int a = scanner.nextInt();

        // Prompt the user to enter the operator (+, -, *, /)
        System.out.println("Enter an operator (+, -, *, /): ");
        String operator = scanner.next();

        // Prompt the user to enter the second value
        System.out.println("Enter second value: ");
        int b = scanner.nextInt();

        // Attempt to perform the calculation and handle any potential exceptions
        try {
            // Call the calculate method with the provided inputs and store the result
            int result = consoleCalculator.calculate(a, b, operator);
            System.out.println("Result: " + result);
            // If an exception is thrown, print the exception message
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // Close the scanner
        scanner.close();
    }
}

