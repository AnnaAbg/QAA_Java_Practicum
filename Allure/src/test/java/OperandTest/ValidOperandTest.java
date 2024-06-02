package OperandTest;

import io.qameta.allure.*;
import org.example.inputValidator.OperandValidator;
import org.testng.annotations.Test;

/**
 * This class contains test methods to validate the correctness of the OperandValidator class "validateInputOperand" method.
 * Each test case provides a different numeric string to check if the OperandValidator correctly
 * identifies it as a valid operand.
 */

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Valid Operand Validation")
public class ValidOperandTest {

    /**
     * Tests the validation input with a single-digit operand.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that a single-digit operand is valid.")
    @Story("Valid Operand with One Digit")
    @Step("Test valid operand '5'")
    @Test
    public void testValidOperandWithOneDigit() {
        OperandValidator.validateInputOperand("5");
    }

    /**
     * Tests the validation input with a two-digit operand.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that a two-digit operand is valid.")
    @Story("Valid Operand with Two Digits")
    @Step("Test valid operand '25'")
    @Test
    public void testValidOperandWithTwoDigits() {
        OperandValidator.validateInputOperand("25");
    }

    /**
     * Tests the validation input with a three-digit operand.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that a three-digit operand is valid.")
    @Story("Valid Operand with Three Digits")
    @Step("Test valid operand '757'")
    @Test
    public void testValidOperandWithThreeDigits() {
        OperandValidator.validateInputOperand("757");
    }

    /**
     * Tests the validation input with a four-digit operand.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that a four-digit operand is valid.")
    @Story("Valid Operand with Four Digits")
    @Step("Test valid operand '6578'")
    @Test
    public void testValidOperandWithFourDigits() {
        OperandValidator.validateInputOperand("6578");
    }

    /**
     * Tests the validation input with a large operand consisting of multiple digits.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that a large operand consisting of multiple digits is valid.")
    @Story("Valid Operand with Multiple Digits")
    @Step("Test valid operand '421785566'")
    @Test
    public void testValidOperandWithBigDigits() {
        OperandValidator.validateInputOperand("421785566");
    }

    /**
     * Tests the validation input with a negative number.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that a negative number operand is valid.")
    @Story("Valid Operand with Negative Number")
    @Step("Test valid operand '-1050'")
    @Test
    public void testValidOperandWithNegativeNumber() {
        OperandValidator.validateInputOperand("-1050");
    }

    /**
     * Tests the validation input with a negative number.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that a zero operand is valid.")
    @Story("Valid Operand with Zero")
    @Step("Test valid operand '0'")
    @Test
    public void testValidOperandWithZero() {
        OperandValidator.validateInputOperand("0");
    }
}
