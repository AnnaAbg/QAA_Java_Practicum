package InvalidOperatorTest;

import org.example.inputValidator.OperandValidator;
import org.example.inputValidator.OperatorValidator;
import org.testng.annotations.Test;

import java.util.InputMismatchException;

/**
 * The  InvalidOperatorTest class contains unit tests to validate invalid operators and input strings.
 */

public class InvalidOperatorTest {

    /**
     * Tests the validation of an invalid operator.
     *
     * @throws IllegalArgumentException if the input string contains an invalid operator
     */

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidOperator() {
        OperatorValidator.validateInputOperator("%");
    }

    /**
     * Tests the validation of an invalid input string.
     *
     * @throws InputMismatchException if the input string is not a valid integer
     */

    @Test(expectedExceptions = InputMismatchException.class)
    public void testInvalidInput() {
        OperandValidator.validateInputOperand("abc");
    }
}
