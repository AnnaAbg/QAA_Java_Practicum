package MathTests;

import io.qameta.allure.*;
import org.example.calculator.BasicCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * The AdditionTest class contains unit tests for testing the addition operation of the BasicCalculator class code.
 */

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Addition Operations")
public class AdditionTest {
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
     * The addition operation with two positive integers.
     *
     * This is the happy path test case.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies the addition of two positive integers")
    @Story("Happy Path for Addition")
    @Step("Test addition of 5 and 7")
    @Test
    public void testAdditionHappyPath() {
        Assert.assertEquals(calculator.calculate(5, "+", 7), 12);
    }

    /**
     * Addition operation with a negative and a positive integer.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies the addition of a negative integer and a positive integer")
    @Story("Addition with Negative and Positive Values")
    @Step("Test addition of -3 and 4")
    @Test
    public void testAdditionWithNegativeValue() {
        Assert.assertEquals(calculator.calculate(-3, "+", 4), 1);
    }

    /**
     * The addition operation with two negative integers.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies the addition of two negative integers")
    @Story("Addition with Negative Values")
    @Step("Test addition of -3 and -4")
    @Test
    public void testAdditionWithNegativeValues() {
        Assert.assertEquals(calculator.calculate(-3, "+", -4), -7);
    }

    /**
     * The addition operation with zero values.
     */

    @Severity(SeverityLevel.TRIVIAL)
    @Description("This test verifies the addition when both operands are zero")
    @Story("Addition with Zero")
    @Step("Test addition of 0 and 0")
    @Test
    public void testAdditionWithZero() {
        Assert.assertEquals(calculator.calculate(0, "+", 0), 0);
    }
}
