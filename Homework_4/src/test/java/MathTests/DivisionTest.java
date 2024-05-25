package MathTests;

import org.example.calculator.BasicCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * The DivisionTest class contains unit tests for testing the division operation of the BasicCalculator class code.
 */

public class DivisionTest {

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
    public void testDivisionHappyPath() {
        Assert.assertEquals(calculator.calculate(12, "/", 6), 2);
    }

    /**
     * The division operation with two negative integers.
     */

    @Test
    public void testDivisionWithNegativeValues() {
        Assert.assertEquals(calculator.calculate(-10, "/", -2), 5);
    }

    /**
     * The division operation where the numerator is zero.
     */

    @Test
    public void testDivisionWithZero() {
        Assert.assertEquals(calculator.calculate(0, "/", 5), 0);
    }

    /**
     * Tests the division operation where the denominator is zero.
     *
     * This test expects an ArithmeticException to be thrown if the division by zero.
     */

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.calculate(8, "/", 0);
    }
}
