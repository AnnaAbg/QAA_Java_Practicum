package OperatorTest;

import org.example.inputValidator.OperatorValidator;
import org.testng.annotations.Test;

/**
 * This class contains test methods to validate the correct operators for the BasicCalculator.
 * Each method tests a different valid operator.
 */

public class ValidOperatorTest {

    /**
     * Tests the validation of the '+' operator.
     */

    @Test
    public void testValidOperatorPlus() {
        OperatorValidator.validateInputOperator("+");
    }

    /**
     * Tests the validation of the '-' operator.
     */

    @Test
    public void testValidOperatorMinus() {
        OperatorValidator.validateInputOperator("-");
    }

    /**
     * Tests the validation of the '*' operator.
     */

    @Test
    public void testValidOperatorMultiply() {
        OperatorValidator.validateInputOperator("*");
    }

    /**
     * Tests the validation of the '/' operator.
     */

    @Test
    public void testValidOperatorDivide() {
        OperatorValidator.validateInputOperator("/");
    }
}
