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
    // private Random random;

    /**
     * Sets up the test environment by initializing a BasicCalculator instance.
     */
    @BeforeMethod
    public void setUp() {
        calculator = new BasicCalculator();
        // random = new Random();
    }
//
//    private String generateRandomOperator() {
//        String[] operators = {"+", "-", "*", "/"};
//        return operators[random.nextInt(operators.length)];
//    }
//
//    @DataProvider(name = "mathATest")
//    public Object[][] mathATest() {
//        Object[][] testData = new Object[12][4];
//
//        for (int i = 0; i < 12; i++) {
//            int num1 = random.nextInt(100) + 1;
//            String operator = generateRandomOperator();
//            int num2 = random.nextInt(100) +1;
//            int expectedResult = calculator.calculate(num1, operator, num2);
//            testData[i] = new Object[]{num1, operator, num2, expectedResult};
//        }
//        return testData;
//    }
//
//    @Test(dataProvider = "mathATest")
//    public void testMath(int num1, String operator, int num2, int expectedResult) {
//        Assert.assertEquals(calculator.calculate(num1, operator, num2), expectedResult);
//    }

    /**
     * Provides test data for arithmetic operations.
     *
     * @return a 2D array of test data where each row contains two operands, an operator, and the expected result.
     */

    @DataProvider(name = "mathTest")
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
    @Test(dataProvider = "mathTest")
    public void testMath(int num1, String operator, int num2, int expectedResult) {
        Assert.assertEquals(calculator.calculate(num1, operator, num2), expectedResult);
    }
}


