package InvalidOperatorTest.parametrized;

import org.example.calculator.BasicCalculator;
import org.example.inputValidator.OperatorValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderInvalidCharactersTest {

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
     * Tests the {@code validateInputOperator} method with various unsafe characters as input.
     * <p>
     * This test method uses a data provider named "unsafeCharacters" to provide input data containing
     * unsafe characters.
     * The method expects an IllegalArgumentException to be thrown for each input string that contains unsafe characters.
     * </p>
     *
     * @param x the input string containing the operator to be tested
     * @throws IllegalArgumentException if the input string contains unsafe characters
     */

    @Test(dataProvider = "unsafeCharacters", expectedExceptions = IllegalArgumentException.class)
    public void testUnsafeCharactersWithDataProvider(String x) {
        OperatorValidator.validateInputOperator(x);
    }
}
