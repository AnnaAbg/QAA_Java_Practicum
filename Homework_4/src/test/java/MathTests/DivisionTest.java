package MathTests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The DivisionTest class extends BaseTest to provide test cases
 * for the division functionality of the MathOperations class.
 */

public class DivisionTest extends BaseTest {

    /**
     * Tests the divide method with two positive integers.
     * Asserts that the result is correct for the happy path scenario.
     */

    @Test
    public void testDivisionHappyPath() {
        Assert.assertEquals(mathOperations.divide(12, 6), 2);
    }

    /**
     * Tests the divide method with two negative integers.
     * Asserts that the result is correct when dividing negative values.
     */

    @Test
    public void testDivisionWithNegativeValues() {
        Assert.assertEquals(mathOperations.divide(-10, -2), 5);
    }

    /**
     * Tests the divide method with zero as the numerator.
     * Asserts that the result is correct when the numerator is zero.
     */

    @Test
    public void testDivisionWithZero() {
        Assert.assertEquals(mathOperations.divide(0, 5), 0);
    }

    /**
     * Tests the  divide method with zero as the denominator.
     * Asserts that an ArithmeticException is thrown when attempting to divide by zero.
     */

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        mathOperations.divide(8, 0);
    }
}
