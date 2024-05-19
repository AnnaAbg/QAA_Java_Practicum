package org.example;

public class MathOperations {

    /**
     * Adds two integers.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The sum of the two integers.
     */

    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtract two integers.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The subtraction of the two integers.
     */

    public int subtract(int a, int b) {
        return a - b;
    }


    /**
     * Multiply two integers.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The multiplication of the two integers.
     */

    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divide two integers.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The division of the two integers.
     * @throws ArithmeticException , if the denominator {code b} is zero.
     */

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed! ");
        }
        return a / b;
    }
}

