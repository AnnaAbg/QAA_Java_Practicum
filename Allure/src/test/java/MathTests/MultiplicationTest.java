package MathTests;

import io.qameta.allure.*;
import org.example.calculator.BasicCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * The MultiplicationTest class contains unit tests for testing the multiplication operation of the BasicCalculator class code.
 */

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Multiplication Operations")
public class MultiplicationTest {

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
     * Tests the multiplication operation with two positive integers.
     *
     * This is the happy path test case.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies the multiplication of two positive integers")
    @Story("Happy Path for Multiplication")
    @Step("Test multiplication of 5 by 5")
    @Test
    public void testMultiplicationHappyPath() {
        Assert.assertEquals(calculator.calculate(5, "*", 5), 25);
    }

    /**
     * The multiplication operation with two negative integers.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies the multiplication of two negative integers.")
    @Story("Multiplication with Negative Values")
    @Step("Test multiplication of -3 by -4")
    @Test
    public void testMultiplicationWithNegativeValues() {
        Assert.assertEquals(calculator.calculate(-3, "*", -4), 12);
    }

    /**
     * The multiplication operation with one operand being zero.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies the multiplication where one operand is zero.")
    @Story("Multiplication with Zero")
    @Step("Test multiplication of 5 by 0")
    @Test
    public void testMultiplicationWithZero() {
        Assert.assertEquals(calculator.calculate(5, "*", 0), 0);
    }
}
