package MathTests;

import org.example.calculator.BasicCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * The MultiplicationTest class contains unit tests for testing the multiplication operation of the BasicCalculator class code.
 */

public class MultiplicationTest {

    private BasicCalculator calculator;

    /**
     * Sets up the test environment by initializing a BasicCalculator instance.
     */

    @BeforeMethod
    public void setUp() {
        calculator = new BasicCalculator();
    }

    /**
     * Tests the multiplication operation with two positive integers.
     *
     * This is the happy path test case.
     */

    @Test
    public void testMultiplicationHappyPath() {
        Assert.assertEquals(calculator.calculate(5, "*", 5), 25);
    }

    /**
     * The multiplication operation with two negative integers.
     */

    @Test
    public void testMultiplicationWithNegativeValues() {
        ;
        Assert.assertEquals(calculator.calculate(-3, "*", -4), 12);
    }

    /**
     * The multiplication operation with one operand being zero.
     */

    @Test
    public void testMultiplicationWithZero() {
        Assert.assertEquals(calculator.calculate(5, "*", 0), 0);
    }
}
