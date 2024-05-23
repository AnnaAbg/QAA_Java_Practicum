package org.example.utils;

import org.example.calculator.BasicCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.inputValidator.OperandValidator.validateInputOperand;
import static org.example.inputValidator.OperatorValidator.validateInputOperator;

/**
 * The ConsoleCalculatorApp class provides a console-based application
 * for performing basic arithmetic calculations.
 */

public class ConsoleCalculatorApp {

    /**
     * The entry point of the console calculator application.
     *
     * This method repeatedly prompts the user to enter two integers and an arithmetic operator,
     * performs the calculation, and displays the result.
     * The application handles input validation and displays appropriate error messages for invalid inputs or operations.
     */
    public static void main(String[] args) {

        BasicCalculator calculator = new BasicCalculator();
        Scanner input = new Scanner(System.in);
        // Create a Scanner object for reading user input from the console

        while (true) {
            try {
                // Prompt the user to enter the first value
                System.out.println("Enter first value:  ");
                int operand1 = validateInputOperand(input.next());

                // Prompt the user to enter the operator (+, -, *, /)
                System.out.println("Enter an operator (+, -, *, /): ");
                String operator = input.next();
                validateInputOperator(input.next());

                // Prompt the user to enter the second value
                System.out.println("Enter second value: ");
                int operand2 = validateInputOperand(input.next());

                int result = calculator.calculate(operand1, operator,operand2 );
                System.out.println("Result: " + result);
            } catch (InputMismatchException | IllegalArgumentException | ArithmeticException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
