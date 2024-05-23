package org.example.inputValidator;

public class OperatorValidator {

    /**
     * The class provides a method to validate an arithmetic operator.
     *
     * @param operator the input string representing the operator to be validated
     * @throws IllegalArgumentException if the input string is not a valid operator
     */

    public static void validateInputOperator(String operator) {
        if (!operator.matches("[+\\-*\\/]")) {
            // If the operator is invalid, throw an IllegalArgumentException
            throw new IllegalArgumentException("Error: Invalid operator -> " + operator);
        }
    }
}
