package InvalidOperatorTest;

import org.example.ConsoleCalculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The InvalidOperatorTest class contains unit tests for the calculate method
 * in the MathOperations class.
 * It tests the behavior of the method when provided with invalid operators.
 */

public class InvalidOperatorTest {

    /**
     * Tests the  calculate method with a single invalid operator.
     * Asserts that the result is 0 when an invalid operator is used.
     */

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidOperator() {
        ConsoleCalculator consoleCalculator = new ConsoleCalculator();
        consoleCalculator.calculate(5, 8, "^");
    }

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
     * Tests the calculate method with various invalid operators using the provided data from unsafeCharacters.
     * Asserts that an IllegalArgumentException is thrown with the appropriate message when an invalid operator is used.
     *
     * @param x the invalid operator to test
     */
    @Test(dataProvider = "unsafeCharacters", expectedExceptions = IllegalArgumentException.class)
    public void testUnsafeCharactersWithDataProvider(String x) {
        ConsoleCalculator consoleCalculator = new ConsoleCalculator();
         consoleCalculator.calculate(5, 8, x);
    }
}
