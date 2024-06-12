package MathTests;

import io.qameta.allure.*;
import org.example.calculator.BasicCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * The SubtractionTest class contains unit tests for testing the subtraction operation of the BasicCalculator class code.
 */

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Subtraction Operations")
public class SubtractionTest {

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
     * Tests the subtraction operation with two positive integers.
     *
     * This is the happy path test case.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies the subtraction of two positive integers")
    @Story("Happy Path for Subtraction")
    @Step("Test subtraction of 10 by 3")
    @Test
    public void testSubtractionHappyPath() {
        Assert.assertEquals(calculator.calculate(10, "-", 3), 7);
    }

    /**
     * The subtraction operation with a negative and a positive integer.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies the subtraction of a negative integer and a positive integer")
    @Story("Subtraction with Negative and Positive Values")
    @Step("Test subtraction of -3 by 5")
    @Test
    public void testSubtractionWithNegativeValue() {
        Assert.assertEquals(calculator.calculate(-3, "-", 5), -8);
    }

    /**
     * The subtraction operation with two negative integers.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies the subtraction of two negative integers")
    @Story("Subtraction with Negative Values")
    @Step("Test subtraction of -3 by -6")
    @Test
    public void testSubtractionWithNegativeValues() {
        Assert.assertEquals(calculator.calculate(-3, "-", -6), 3);
    }

    /**
     * The subtraction operation with a zero value.
     */

    @Severity(SeverityLevel.TRIVIAL)
    @Description("This test verifies the subtraction operation where the subtrahend is zero")
    @Story("Subtraction with Zero")
    @Step("Test subtraction of 5 by 0")
    @Test
    public void testSubtractionWithZero() {
        Assert.assertEquals(calculator.calculate(5, "-", 0), 5);
    }
}
