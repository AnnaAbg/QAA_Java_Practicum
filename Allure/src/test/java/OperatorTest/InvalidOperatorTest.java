package OperatorTest;

import io.qameta.allure.*;
import org.example.inputValidator.OperatorValidator;
import org.testng.annotations.Test;

/**
 * The  InvalidOperatorTest class contains unit tests to validate invalid operators and input strings.
 *
 * @throws IllegalArgumentException if the input string contains an invalid operator
 */

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Invalid Operator Validation")
public class InvalidOperatorTest {

    /**
     * Tests the validation of an invalid '%' operator.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that an IllegalArgumentException is thrown for the invalid '%' operator.")
    @Story("Invalid Operator: Percent")
    @Step("Test invalid operator '%'")
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidOperatorPercent() {
        OperatorValidator.validateInputOperator("%");
    }

    /**
     * Tests the validation of an invalid '^' operator.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that an IllegalArgumentException is thrown for the invalid '^' operator.")
    @Story("Invalid Operator: Caret")
    @Step("Test invalid operator '^'")
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidOperatorCaret() {
        OperatorValidator.validateInputOperator("^");
    }

    /**
     * Tests the validation of an invalid '&' operator.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that an IllegalArgumentException is thrown for the invalid '&' operator.")
    @Story("Invalid Operator: Ampersand")
    @Step("Test invalid operator '&'")
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidOperatorAmpersand() {
        OperatorValidator.validateInputOperator("&");
    }

    /**
     * Tests the validation of an invalid '@' operator.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that an IllegalArgumentException is thrown for the invalid '@' operator.")
    @Story("Invalid Operator: At")
    @Step("Test invalid operator '@'")
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidOperatorAt() {
        OperatorValidator.validateInputOperator("@");
    }
}
