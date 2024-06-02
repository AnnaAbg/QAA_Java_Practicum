package MathTests;

import io.qameta.allure.*;
import org.example.calculator.BasicCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * The DivisionTest class contains unit tests for testing the division operation of the BasicCalculator class code.
 */

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Division Operations")
public class DivisionTest {

    private BasicCalculator calculator;

    /**
     * Sets up the test environment by initializing a BasicCalculator instance.
     */

    @BeforeMethod
    @Description("Sets up the test environment by initializing a BasicCalculator instance.")
    public void setUp() {
        calculator = new BasicCalculator();
    }

    /**
     * The division operation with two positive integers.
     *
     * This is the happy path test case.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies the division of two positive integers")
    @Story("Happy Path for Division")
    @Step("Test division of 12 by 6")
    @Test
    public void testDivisionHappyPath() {
        Assert.assertEquals(calculator.calculate(12, "/", 6), 2);
    }

    /**
     * The division operation with two negative integers.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies the division of two negative integers")
    @Story("Division with Negative Values")
    @Step("Test division of -10 by -2")
    @Test
    public void testDivisionWithNegativeValues() {
        Assert.assertEquals(calculator.calculate(-10, "/", -2), 5);
    }

    /**
     * The division operation where the numerator is zero.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies the division where the numerator is zero")
    @Story("Division with Zero Numerator")
    @Step("Test division of 0 by 5")
    @Test
    public void testDivisionWithZero() {
        Assert.assertEquals(calculator.calculate(0, "/", 5), 0);
    }

    /**
     * Tests the division operation where the denominator is zero.
     * <p>
     * This test expects an ArithmeticException to be thrown if the division by zero.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that an ArithmeticException is thrown for division by zero")
    @Story("Division by Zero")
    @Step("Test division of 8 by 0")
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.calculate(8, "/", 0);
    }
}
