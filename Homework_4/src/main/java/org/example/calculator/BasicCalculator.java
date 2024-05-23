package org.example.calculator;
public class BasicCalculator {

    /**
     * Performs a basic arithmetic operation on two integers based on the given operator.
     * <p>
     * Supported operations are addition, subtraction, multiplication, and division.
     *
     * @param num1 the first operand
     * @param operator the operator as a string, which can be one of "+", "-", "*", or "/"
     * @param num2 the second operand
     * @return the result of the arithmetic operation
     * @throws ArithmeticException if division by zero is attempted
     */
    public int calculate(int num1, String operator, int num2) {
        int result = 0;

        // Perform calculation based on the operation
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
                    throw new ArithmeticException("Error: Division by zero is not allowed!");
                }
                result = num1 / num2;
                break;
        }
        return result;
    }
}
