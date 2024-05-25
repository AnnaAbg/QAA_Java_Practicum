package ParametrizedTests.parametrizedOperatorTest;

import org.example.inputValidator.OperatorValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class InvalidCharactersTest {

    /**
     * Provides test data for the invalid operator tests.
     *
     * @return a 2D array of invalid operators that are considered unsafe characters.
     */

    @DataProvider(name = "unsafeCharacters")
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

    @Test(dataProvider = "unsafeCharacters", expectedExceptions = IllegalArgumentException.class)
    public void testUnsafeCharactersWithDataProvider(String operator) {
        OperatorValidator.validateInputOperator(operator);
    }
}
