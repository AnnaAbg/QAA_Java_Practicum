package ParametrizedTests.parametrizedOperatorTest;

import io.qameta.allure.*;
import org.example.inputValidator.OperatorValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Parametrized tests. Invalid Characters Validation")
public class InvalidCharactersTest {

    /**
     * Provides test data for the invalid operator tests.
     *
     * @return a 2D array of invalid operators that are considered unsafe characters.
     */

    @DataProvider(name = "unsafeCharacters")
    @Description("Provides a list of unsafe characters for testing invalid operator/character validation")
    public Object[][] unsafeCharacters() {
        return new Object[][]{
                {"!"}, {"#"}, {"$"}, {"%"}, {"&"}, {";"}, {":"},
                {">"}, {"<"}, {"?"}, {"@"}, {"["}, {"\\"}, {"]"}, {"^"}, {"|"}
        };
    }

    /**
     * Tests the validateInputOperator method with various unsafe characters as input.
     *
     * @param operator the input string containing the operator to be tested
     * @throws IllegalArgumentException if the input string contains unsafe characters
     */

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that an IllegalArgumentException is thrown for unsafe characters used as operators.")
    @Story("Invalid Operator: Unsafe Characters")
    @Step("Test invalid operator '{operator}'")
    @Test(dataProvider = "unsafeCharacters", expectedExceptions = IllegalArgumentException.class)
    public void testUnsafeCharactersWithDataProvider(String operator) {
        OperatorValidator.validateInputOperator(operator);
    }
}
