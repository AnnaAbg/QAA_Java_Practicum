package MathTests;

import org.example.calculator.BasicCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The SubtractionTest class contains unit tests for testing the subtraction operation of the BasicCalculator class code.
 */

public class SubtractionTest {

    private BasicCalculator calculator;

    /**
     * Sets up the test environment by initializing a BasicCalculator instance.
     */

    @BeforeClass
    public void setUp() {
        calculator = new BasicCalculator();
    }

    /**
     * Tests the subtraction operation with two positive integers.
     *
     * This is the happy path test case.
     */

    @Test
    public void testSubtractionHappyPath() {
        Assert.assertEquals(calculator.calculate(10, "-", 3), 7);
    }

    /**
     * The subtraction operation with a negative and a positive integer.
     */

    @Test
    public void testSubtractionWithNegativeValue() {
        Assert.assertEquals(calculator.calculate(-3, "-", 5), -8);
    }

    /**
     * The subtraction operation with two negative integers.
     */

    @Test
    public void testSubtractionWithNegativeValues() {
        Assert.assertEquals(calculator.calculate(-3, "-", -6), 3);
    }

    /**
     * The subtraction operation with a zero value.
     */

    @Test
    public void testSubtractionWithZero() {
        Assert.assertEquals(calculator.calculate(5, "-", 0), 5);
    }
}
