package MathTests;

import org.example.calculator.BasicCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * The AdditionTest class contains unit tests for testing the addition operation of the BasicCalculator class code.
 */

public class AdditionTest {
    private BasicCalculator calculator;

    /**
     * Sets up the test environment by initializing a BasicCalculator instance.
     */
    @BeforeMethod
    public void setUp() {
        calculator = new BasicCalculator();
    }

    /**
     * The addition operation with two positive integers.
     *
     * This is the happy path test case.
     */

    @Test
    public void testAdditionHappyPath() {
        Assert.assertEquals(calculator.calculate(5, "+", 7), 12);
    }

    /**
     * Addition operation with a negative and a positive integer.
     */

    @Test
    public void testAdditionWithNegativeValue() {
        Assert.assertEquals(calculator.calculate(-3, "+", 4), 1);
    }

    /**
     * The addition operation with two negative integers.
     */

    @Test
    public void testAdditionWithNegativeValues() {
        Assert.assertEquals(calculator.calculate(-3, "+", -4), -7);
    }

    /**
     * The addition operation with zero values.
     */

    @Test
    public void testAdditionWithZero() {
        Assert.assertEquals(calculator.calculate(0, "+", 0), 0);
    }
}
