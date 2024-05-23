package ParametrizedTests;

import org.example.calculator.BasicCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The DataProviderMathTest class contains unit tests for the BasicCalculator class code
 * to test various arithmetic operations.
 */

public class MathTests {

    private BasicCalculator calculator;

    /**
     * Sets up the test environment by initializing a BasicCalculator instance.
     */

    @BeforeMethod
    public void setUp() {
        calculator = new BasicCalculator();
    }

    /**
     * Provides test data for the addition tests.
     *
     * @return a 2D array of test data where each row contains two operands, an operator, and the expected result.
     */
    @DataProvider(name = "additionTest")
    public Object[][] additionTest() {
        return new Object[][]{
                {2, "+", 2, 4},
                {-3, "+", 5, 2},
                {-3, "+", -4, -7},
                {0, "+", 0, 0}
        };
    }

    /**
     * Tests the addition operation using the provided test data.
     *
     * @param num1           the first operand
     * @param operator       the operator (should be "+")
     * @param num2           the second operand
     * @param expectedResult the expected result of the addition
     */

    @Test(dataProvider = "additionTest")
    public void testAddition(int num1, String operator, int num2, int expectedResult) {
        Assert.assertEquals(calculator.calculate(num1, operator, num2), expectedResult);
    }

    /**
     * Provides test data for the subtraction tests.
     *
     * @return a 2D array of test data where each row contains two operands, an operator, and the expected result.
     */

    @DataProvider(name = "subtractionTest")
    public Object[][] subtractionTest() {
        return new Object[][]{
                {10, "-", 3, 7},
                {-3, "-", 5, -8},
                {-3, "-", -6, 3},
                {5, "-", 0, 5}
        };
    }

    /**
     * Tests the subtraction operation using the provided test data.
     *
     * @param num1           the first operand
     * @param operator       the operator (should be "-")
     * @param num2           the second operand
     * @param expectedResult the expected result of the subtraction
     */

    @Test(dataProvider = "subtractionTest")
    public void testSubtraction(int num1, String operator, int num2, int expectedResult) {
        Assert.assertEquals(calculator.calculate(num1, operator, num2), expectedResult);
    }

    /**
     * Provides test data for the multiplication tests.
     *
     * @return a 2D array of test data where each row contains two operands, an operator, and the expected result.
     */

    @DataProvider(name = "multiplicationTest")
    public Object[][] multiplicationTest() {
        return new Object[][]{
                {5, "*", 5, 25},
                {-3, "*", 4, -12},
                {5, "*", 0, 0}
        };
    }

    /**
     * Tests the multiplication operation using the provided test data.
     *
     * @param num1           the first operand
     * @param operator       the operator (should be "*")
     * @param num2           the second operand
     * @param expectedResult the expected result of the multiplication
     */

    @Test(dataProvider = "multiplicationTest")
    public void testMultiplication(int num1, String operator, int num2, int expectedResult) {
        Assert.assertEquals(calculator.calculate(num1, operator, num2), expectedResult);
    }

    /**
     * Provides test data for the division tests.
     *
     * @return a 2D array of test data where each row contains two operands, an operator, and the expected result.
     */

    @DataProvider(name = "divisionTest")
    public Object[][] divisionTest() {
        return new Object[][]{
                {12, "/", 6, 2},
                {-10, "/", -2, 5},
                {0, "/", 5, 0}
        };
    }

    /**
     * Tests the division operation using the provided test data.
     *
     * @param num1           the first operand
     * @param operator       the operator (should be "/")
     * @param num2           the second operand
     * @param expectedResult the expected result of the division
     */

    @Test(dataProvider = "divisionTest")
    public void testDivision(int num1, String operator, int num2, int expectedResult) {
        Assert.assertEquals(calculator.calculate(num1, operator, num2), expectedResult);
    }

    /**
     * Provides test data for the division by zero tests.
     *
     * @return a 2D array of test data where each row contains two operands and an operator.
     */

    @DataProvider(name = "divisionByZeroTest")
    public Object[][] divisionByZeroTest() {
        return new Object[][]{
                {8, "/", 0}
        };
    }

    /**
     * Tests the division operation where the denominator is zero.
     *
     * This test expects an ArithmeticException to be thrown.
     *
     * @param num1     the first operand
     * @param operator the operator (should be "/")
     * @param num2     the second operand (should be 0)
     */

    @Test(dataProvider = "divisionByZeroTest", expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero(int num1, String operator, int num2) {
        calculator.calculate(num1, operator, num2);
    }
}


