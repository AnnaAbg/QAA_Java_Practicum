package OperatorTest;

import org.example.inputValidator.OperatorValidator;
import org.testng.annotations.Test;

/**
 * The  InvalidOperatorTest class contains unit tests to validate invalid operators and input strings.
 *
 * @throws IllegalArgumentException if the input string contains an invalid operator
 */

public class InvalidOperatorTest {

    /**
     * Tests the validation of an invalid '%' operator.
     */

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidOperatorPercent() {
        OperatorValidator.validateInputOperator("%");
    }

    /**
     * Tests the validation of an invalid '^' operator.
     */

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidOperatorCaret() {
        OperatorValidator.validateInputOperator("^");
    }

    /**
     * Tests the validation of an invalid '&' operator.
     */

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidOperatorAmpersand() {
        OperatorValidator.validateInputOperator("&");
    }

    /**
     * Tests the validation of an invalid '@' operator.
     */

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidOperatorAt() {
        OperatorValidator.validateInputOperator("@");
    }
}
