package org.example.inputValidator;

import java.util.InputMismatchException;

public class OperandValidator {

    /**
     * The class provides a method to validate and convert a string input to an integer.
     *
     * @param input the input string to be validated and converted
     * @return the integer value of the input string
     * @throws InputMismatchException if the input string is not a valid integer
     */

    public static int validateInputOperand(String input) {
        if (input.matches("[+-]?\\d+")) {
            return Integer.parseInt(input);
        } else {
            throw new InputMismatchException("Error: Invalid input! Please use only integer numbers!");
        }
    }
}
