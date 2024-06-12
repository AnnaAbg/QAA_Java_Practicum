package ParametrizedTests.parametrizedOperatorTest;

import io.qameta.allure.*;
import org.example.inputValidator.OperatorValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Parametrized tests. Valid Operator Validation")
public class ValidOperatorTest {

    /**
     * Provides valid operators for testing.
     *
     * @return a 2D array containing valid operators.
     */
    @DataProvider(name = "validOperators")
    @Description("Provides valid operators for testing")
    public Object[][] validOperators() {
        return new Object[][]{
                {"+"},
                {"-"},
                {"*"},
                {"/"}
        };
    }

    /**
     * Tests valid operators.
     *
     * @param operator the operator to be validated
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that valid operators are correctly validated")
    @Story("Valid Operator Tests")
    @Step("Test valid operator '{operator}'")
    @Test(dataProvider = "validOperators")
    public void testValidOperators(String operator) {
        OperatorValidator.validateInputOperator(operator);
    }
}
