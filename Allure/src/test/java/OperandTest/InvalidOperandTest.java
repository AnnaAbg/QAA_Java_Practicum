package OperandTest;

import io.qameta.allure.*;
import org.example.inputValidator.OperandValidator;
import org.testng.annotations.Test;

import java.util.InputMismatchException;

/**
 * This class contains test methods to validate that the OperandValidator class validateInputOperand method correctly
 *
 * @throws InputMismatchException if the input string is not a valid integer
 * Each test case provides a different invalid numeric and alphanumeric string to ensure proper exception handling.
 */

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Invalid Operand Validation")
public class InvalidOperandTest {

    /**
     * Tests the validation input with an operand containing a decimal point.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that an InputMismatchException is thrown for an operand containing a decimal point")
    @Story("Invalid Operand with Decimal Point")
    @Step("Test invalid operand '5.2'")
    @Test(expectedExceptions = InputMismatchException.class)
    public void testInvalidOperandWithDecimal() {
        OperandValidator.validateInputOperand("5.2");
    }

    /**
     * Tests the validation input with an operand containing a single letter.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that an InputMismatchException is thrown for an operand containing a single letter.")
    @Story("Invalid Operand with a single Letter")
    @Step("Test invalid operand 'a'")
    @Test(expectedExceptions = InputMismatchException.class)
    public void testInvalidOperandWithSingleLetter() {
        OperandValidator.validateInputOperand("a");
    }

    /**
     * Tests the validation input with an operand containing multiple letters.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that an InputMismatchException is thrown for an operand containing multiple letters.")
    @Story("Invalid Operand with Multiple Letters")
    @Step("Test invalid operand 'abc'")
    @Test(expectedExceptions = InputMismatchException.class)
    public void testInvalidOperandWithMultipleLetters() {
        OperandValidator.validateInputOperand("abc");
    }

    /**
     * Tests the validation input with an alphanumeric operand..
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that an InputMismatchException is thrown for an alphanumeric operand.")
    @Story("Invalid Operand with Alphanumeric Characters")
    @Step("Test invalid operand '125xy'")
    @Test(expectedExceptions = InputMismatchException.class)
    public void testInvalidOperandWithAlphanumeric() {
        OperandValidator.validateInputOperand("125xy");
    }
}
