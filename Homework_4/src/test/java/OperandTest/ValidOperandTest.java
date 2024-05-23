package OperandTest;

import org.example.inputValidator.OperandValidator;
import org.testng.annotations.Test;

/**
 * This class contains test methods to validate the correctness of the OperandValidator class "validateInputOperand" method.
 * Each test case provides a different numeric string to check if the OperandValidator correctly
 * identifies it as a valid operand.
 */

public class ValidOperandTest {

    /**
     * Tests the validation input with a single-digit operand.
     */

    @Test
    public void testValidOperandWithOneDigit() {
        OperandValidator.validateInputOperand("5");
    }

    /**
     * Tests the validation input with a two-digit operand.
     */

    @Test
    public void testValidOperandWithTwoDigits() {
        OperandValidator.validateInputOperand("25");
    }

    /**
     * Tests the validation input with a three-digit operand.
     */

    @Test
    public void testValidOperandWithThreeDigits() {
        OperandValidator.validateInputOperand("757");
    }

    /**
     * Tests the validation input with a four-digit operand.
     */

    @Test
    public void testValidOperandWithFourDigits() {
        OperandValidator.validateInputOperand("6578");
    }

    /**
     * Tests the validation input with a large operand consisting of multiple digits.
     */

    @Test
    public void testValidOperandWithBigDigits() {
        OperandValidator.validateInputOperand("421785566");
    }

    /**
     * Tests the validation input with a negative number.
     */

    @Test
    public void testValidOperandWithNegativeNumber() {
        OperandValidator.validateInputOperand("-1050");
    }

    /**
     * Tests the validation input with a negative number.
     */

    @Test
    public void testValidOperandWithZero() {
        OperandValidator.validateInputOperand("0");
    }
}
