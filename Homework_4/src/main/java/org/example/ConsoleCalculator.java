package org.example;


import java.util.regex.Pattern;

/**
 * The ConsoleCalculator code class provides a method to perform basic arithmetic
 * operations such as addition, subtraction, multiplication, and division.
 */
public class ConsoleCalculator {

    /**
     * Method "calculate" performs a calculation based on the provided operator and two integer operands.
     *
     * @param num1     the first operand
     * @param num2     the second operand
     * @param operator a string representing the operation to be performed  (e.g., "+", "-", "*", "/")
     * @return the result of the arithmetic operation
     * @throws IllegalArgumentException if the operator is not one of the valid arithmetic operators ("+", "-", "*", "/")
     * @throws ArithmeticException      if division by zero is attempted
     */

    public int calculate(int num1, int num2, String operator) throws IllegalArgumentException {
        int result = 0;

       // Compile a regex pattern to match valid operators (+, -, *, /)
        Pattern operatorPattern = Pattern.compile("[+\\-*\\/]");

        // Check if the provided operator matches the pattern
        if (!operatorPattern.matcher(operator).matches()) {
            // If the operator is invalid, throw an IllegalArgumentException
            throw new IllegalArgumentException("Error: Invalid operator!");
        }

        // Use a switch statement to perform the appropriate calculation based on the operator
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                  // If the second operand is zero, throw an ArithmeticException
                    throw new ArithmeticException("Error: Division by zero is not allowed!");
                }
                result = num1 / num2;
                break;
                /*
                Alternative
                default:
                   throw new IllegalArgumentException("Error: Invalid operator!");
                 */
        }
        return result;
    }
}
