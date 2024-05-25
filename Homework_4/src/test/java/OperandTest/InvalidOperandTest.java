package OperandTest;

import org.example.inputValidator.OperandValidator;
import org.testng.annotations.Test;

import java.util.InputMismatchException;

/**
 * This class contains test methods to validate that the OperandValidator class validateInputOperand method correctly
 *
 * @throws InputMismatchException if the input string is not a valid integer
 * Each test case provides a different invalid numeric and alphanumeric string to ensure proper exception handling.
 */

public class InvalidOperandTest {

    /**
     * Tests the validation input  with an operand containing a decimal point.
     */

    @Test(expectedExceptions = InputMismatchException.class)
    public void testInvalidOperandWithDecimal() {
        OperandValidator.validateInputOperand("5.2");
    }

    /**
     * Tests the validation input with an operand containing multiple decimal places..
     */

    @Test(expectedExceptions = InputMismatchException.class)
    public void testInvalidOperandWithMultipleDecimals() {
        OperandValidator.validateInputOperand("8.429");
    }

    /**
     * Tests the validation input with an operand containing a single letter.
     */

    @Test(expectedExceptions = InputMismatchException.class)
    public void testInvalidOperandWithSingleLetter() {
        OperandValidator.validateInputOperand("a");
    }

    /**
     * Tests the validation input with an operand containing multiple letters.
     */

    @Test(expectedExceptions = InputMismatchException.class)
    public void testInvalidOperandWithMultipleLetters() {
        OperandValidator.validateInputOperand("abc");
    }

    /**
     * Tests the validation input with an alphanumeric operand..
     */

    @Test(expectedExceptions = InputMismatchException.class)
    public void testInvalidOperandWithAlphanumeric() {
        OperandValidator.validateInputOperand("125xy");
    }
}
