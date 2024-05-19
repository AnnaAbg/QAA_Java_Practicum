package MathTests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The MultiplicationTest class extends BaseTest to provide test cases
 * for the multiplication functionality of the MathOperations class.
 */

public class MultiplicationTest extends BaseTest {

    /**
     * Tests the multiply method with two positive integers.
     * Asserts that the result is correct for the happy path scenario.
     */

    @Test
    public void testMultiplicationHappyPath() {
        Assert.assertEquals(mathOperations.multiply(5, 5), 25);
    }

    /**
     * Tests the multiply method with a negative and a positive integer.
     * Asserts that the result is correct when multiplying a negative value with a positive value.
     */

    @Test
    public void testMultiplicationWithNegativeValues() {
        Assert.assertEquals(mathOperations.multiply(-3, 4), -12);
    }

    /**
     * Tests the multiply method with zero.
     * Asserts that the result is correct when multiplying any number with zero.
     */

    @Test
    public void testMultiplicationWithZero() {
        Assert.assertEquals(mathOperations.multiply(5, 0), 0);
    }
}
