package ParametrizedTests.parametrizedOperatorTest;

import org.example.inputValidator.OperatorValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidOperatorTest {

    /**
     * Provides valid operators for testing.
     *
     * @return a 2D array containing valid operators.
     */
    @DataProvider(name = "validOperators")
    public Object[][] validOperators() {
        return new Object[][]{
                { "+" },
                { "-" },
                { "*" },
                { "/" }
        };
    }

    /**
     * Tests valid operators.
     *
     * @param operator the operator to be validated
     */
    @Test(dataProvider = "validOperators")
    public void testValidOperators(String operator) {
        OperatorValidator.validateInputOperator(operator);
    }
}
