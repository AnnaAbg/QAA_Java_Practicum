package OperatorTest;

import io.qameta.allure.*;
import org.example.inputValidator.OperatorValidator;
import org.testng.annotations.Test;

/**
 * This class contains test methods to validate the correct operators for the BasicCalculator.
 * Each method tests a different valid operator.
 */

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Valid Operator Validation")
public class ValidOperatorTest {

    /**
     * Tests the validation of the '+' operator.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that the '+' operator is valid.")
    @Story("Valid Operator: Plus")
    @Step("Test valid operator '+'")
    @Test
    public void testValidOperatorPlus() {
        OperatorValidator.validateInputOperator("+");
    }

    /**
     * Tests the validation of the '-' operator.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that the '-' operator is valid.")
    @Story("Valid Operator: Minus")
    @Step("Test valid operator '-'")
    @Test
    public void testValidOperatorMinus() {
        OperatorValidator.validateInputOperator("-");
    }

    /**
     * Tests the validation of the '*' operator.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that the '*' operator is valid.")
    @Story("Valid Operator: Multiply")
    @Step("Test valid operator '*'")
    @Test
    public void testValidOperatorMultiply() {
        OperatorValidator.validateInputOperator("*");
    }

    /**
     * Tests the validation of the '/' operator.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that the '/' operator is valid.")
    @Story("Valid Operator: Divide")
    @Step("Test valid operator '/'")
    @Test
    public void testValidOperatorDivide() {
        OperatorValidator.validateInputOperator("/");
    }
}
