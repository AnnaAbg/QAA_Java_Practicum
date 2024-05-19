package MathTests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The SubtractionTest class extends BaseTest to provide test cases
 * for the subtraction functionality of the MathOperations class.
 */

public class SubtractionTest extends BaseTest {

    /**
     * Tests the subtract method with two positive integers.
     * Asserts that the result is correct for the happy path scenario.
     */

    @Test
    public void testSubtractionHappyPath() {
        Assert.assertEquals(mathOperations.subtract(10, 3), 7);
    }

    /**
     * Tests the subtract method with a negative and a positive integer.
     * Asserts that the result is correct when subtracting a positive value from a negative value.
     */

    @Test
    public void testSubtractionWithNegativeValue() {
        Assert.assertEquals(mathOperations.subtract(-3, 5), -8);
    }

    /**
     * Tests the subtract method with two negative integers.
     * Asserts that the result is correct when subtracting negative values.
     */

    @Test
    public void testSubtractionWithNegativeValues() {
        Assert.assertEquals(mathOperations.subtract(-3, -6), 3);
    }

    /**
     * Tests the subtract method with zero.
     * Asserts that the result is correct when subtracting zero from a positive value.
     */

    @Test
    public void testSubtractionWithZero() {
        Assert.assertEquals(mathOperations.subtract(5, 0), 5);
    }
}
