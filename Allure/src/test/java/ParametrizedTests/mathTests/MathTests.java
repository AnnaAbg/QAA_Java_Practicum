package ParametrizedTests.mathTests;

import io.qameta.allure.*;
import org.example.calculator.BasicCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The DataProviderMathTest class contains unit tests for the BasicCalculator class code
 * to test various arithmetic operations.
 */

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Parametrized tests. Arithmetic Operations")
public class MathTests {

    private BasicCalculator calculator;


    @BeforeTest
    @Description("Sets up the test environment by initializing the calculator.")
    public void setUp() {
        calculator = new BasicCalculator();
    }

    /**
     * Provides test data for arithmetic operations.
     *
     * @return a 2D array of test data where each row contains two operands, an operator, and the expected result.
     */

    @DataProvider(name = "mathTest")
    @Description("Provides test data for arithmetic operations")
    public Object[][] mathTest() {
        return new Object[][]{
                {2, "+", 2, 4},
                {-3, "+", 5, 2},
                {-3, "+", -4, -7},
                {0, "+", 0, 0},
                {10, "-", 3, 7},
                {-3, "-", 5, -8},
                {-3, "-", -6, 3},
                {5, "-", 0, 5},
                {7, "*", 5, 35},
                {5, "*", 0, 0},
                {12, "/", 6, 2},
                {-10, "/", -2, 5},
                {0, "/", 5, 0},
        };
    }

    /**
     * Tests arithmetic operations using the provided test data.
     *
     * @param num1           the first operand
     * @param operator       the operator (e.g., "+", "-", "*", "/")
     * @param num2           the second operand
     * @param expectedResult the expected result of the operation
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies arithmetic operations with various test data.")
    @Story("Arithmetic Operations")
    @Step("Test arithmetic operation: {num1} {operator} {num2}")
    @Test(dataProvider = "mathTest")
    public void testMath(int num1, String operator, int num2, int expectedResult) {
        Assert.assertEquals(calculator.calculate(num1, operator, num2), expectedResult);
    }
}
