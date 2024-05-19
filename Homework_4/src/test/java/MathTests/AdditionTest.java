package MathTests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The AdditionTest class extends BaseTest to provide test cases
 * for the addition functionality of the MathOperations class.
 */

public class AdditionTest extends BaseTest {

    /**
     * Tests the add method with two positive integers.
     * Asserts that the result is correct for the happy path scenario.
     */

    @Test
    public void testAdditionHappyPath() {
        Assert.assertEquals(mathOperations.add(2, 5), 7);
    }

    /**
     * Tests the add method with a negative and a positive integer.
     * Asserts that the result is correct when adding a negative value.
     */

    @Test
    public void testAdditionWithNegativeValue() {
        Assert.assertEquals(mathOperations.add(-3, 4), 1);
    }

    /**
     * Tests the add method with two negative integers.
     * Asserts that the result is correct when adding negative values.
     */

    @Test
    public void testAdditionWithNegativeValues() {
        Assert.assertEquals(mathOperations.add(-3, -4), -7);
    }

    /**
     * Tests the add method with two zeros.
     * Asserts that the result is correct when adding zero values.
     */

    @Test
    public void testAdditionWithZero() {
        Assert.assertEquals(mathOperations.add(0, 0), 0);
    }
}
