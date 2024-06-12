package ParametrizedTests.mathTests;

import io.qameta.allure.*;
import org.example.calculator.BasicCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * The DataProviderMathTest class contains unit tests for the BasicCalculator class code
 * to test various arithmetic operations with random numbers
 */

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Parametrized tests. Arithmetic Operations")
public class MathTestsWithRandomNumbers {
    private BasicCalculator calculator;
    private Random random;
    private String operator;


    @BeforeTest
    @Description("Sets up the test environment by initializing the calculator and random number generator.")
    public void setUp() {
        calculator = new BasicCalculator();
        random = new Random();
    }

    /**
     * Provides test data for various mathematical operations. Generates random numbers for testing.
     *
     * @return An array of objects containing test data: two integers, an operator, and the expected result.
     */
    @DataProvider(name = "mathTestDataProvider")
    public Object[][] getMathTestDatProvider() {
        int num1 = random.nextInt(100);
        int num2 = random.nextInt(100);
        return new Object[][]{
                {num1, "+", -num2, num1 + (-num2)},
                {num1, "+", num2, (num1 + num2)},
                {-num1, "+", 0, -num1},
                {num1, "-", num2, num1 - num2},
                {num1, "*", num2, num1 * num2},
                {num1, "/", num2, (num2 != 0 ? (num1 / num2) : null)}
        };
    }

    /**
     * Tests the calculator with random mathematical operations using data provided by the data provider.
     *
     * @param num1           The first number.
     * @param operator       The mathematical operator (e.g., "+", "-", "*", "/").
     * @param num2           The second number.
     * @param expectedResult The expected result of the operation.
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies arithmetic operations with various test data.")
    @Story("Arithmetic Operations")
    @Step("Test arithmetic operation: {num1} {operator} {num2}")
    @Test(dataProvider = "mathTestDataProvider")
    public void testMathRandom(int num1, String operator, int num2, int expectedResult) {
        Assert.assertEquals(calculator.calculate(num1, operator, num2), expectedResult);
    }
}


