package ParametrizedTests;

import MathTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The DataProviderMathTest class extends BaseTest to provide test cases
 * for various mathematical operations using data providers.
 */

public class DataProviderMathTest extends BaseTest {

    /**
     * Provides test data for the addition tests.
     *
     * @return a 2D array of test data where each row contains two operands and the expected result.
     */
    @DataProvider(name = "additionTest")
    public Object[][] additionTest() {
        return new Object[][]{
                {2, 2, 4},
                {-3, 5, 2},
                {-3, -4, -7},
                {0, 0, 0}
        };
    }

    /**
     * Tests the add method using the provided data from additionTest.
     *
     * @param a              the first operand
     * @param b              the second operand
     * @param expectedResult the expected result of the addition
     */

    @Test(dataProvider = "additionTest")
    public void testAddition(int a, int b, int expectedResult) {
        Assert.assertEquals(a + b, expectedResult);
    }

    /**
     * Provides test data for the subtraction tests.
     *
     * @return a 2D array of test data where each row contains two operands and the expected result.
     */

    @DataProvider(name = "subtractionTest")
    public Object[][] subtractionTest() {
        return new Object[][]{
                {10, 3, 7},
                {-3, 5, -8},
                {-3, -6, 3},
                {5, 0, 5}
        };
    }

    /**
     * Tests the subtract method using the provided data from subtractionTest.
     *
     * @param a              the first operand
     * @param b              the second operand
     * @param expectedResult the expected result of the subtraction
     */

    @Test(dataProvider = "subtractionTest")
    public void testSubtraction(int a, int b, int expectedResult) {
        Assert.assertEquals(mathOperations.subtract(a, b), expectedResult);
    }

    /**
     * Provides test data for the multiplication tests.
     *
     * @return a 2D array of test data where each row contains two operands and the expected result.
     */

    @DataProvider(name = "multiplicationTest")
    public Object[][] multiplicationTest() {
        return new Object[][]{
                {5, 5, 25},
                {-3, 4, -12},
                {5, 0, 0}
        };
    }

    /**
     * Tests the multiply method using the provided data from multiplicationTest.
     *
     * @param a              the first operand
     * @param b              the second operand
     * @param expectedResult the expected result of the multiplication
     */

    @Test(dataProvider = "multiplicationTest")
    public void testMultiplication(int a, int b, int expectedResult) {
        Assert.assertEquals(mathOperations.multiply(a, b), expectedResult);
    }


    /**
     * Provides test data for the division tests.
     *
     * @return a 2D array of test data where each row contains two operands and the expected result.
     */
    @DataProvider(name = "divisionTest")
    public Object[][] divisionTest() {
        return new Object[][]{
                {12, 6, 2},
                {-10, -2, 5},
                {0, 5, 0}
        };
    }

    /**
     * Tests the divide method using the provided data from divisionTest.
     *
     * @param a              the first operand
     * @param b              the second operand
     * @param expectedResult the expected result of the division
     */
    @Test(dataProvider = "divisionTest")
    public void testDivision(int a, int b, int expectedResult) {
        Assert.assertEquals(mathOperations.divide(a, b), expectedResult);
    }


    /**
     * Provides test data for the division by zero test.
     *
     * @return a 2D array of test data where each row contains two operands.
     */

    @DataProvider(name = "divisionByZeroTest")
    public Object[][] divisionByZeroTest() {
        return new Object[][]{
                {8, 0}
        };
    }

    /**
     * Tests the divide method for division by zero.
     *
     * @param a the first operand
     * @param b the second operand
     * @throws ArithmeticException when division by zero is attempted
     */

    @Test(dataProvider = "divisionByZeroTest", expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero(int a, int b) {
        mathOperations.divide(a, b);
    }
}


