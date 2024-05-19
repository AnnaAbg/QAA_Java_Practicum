package MathTests;

import org.example.MathOperations;
import org.testng.annotations.BeforeMethod;

/**
 * The BaseTest abstract class provides a common setup for test classes
 * that involve arithmetic operations.
 * It initializes an instance of MathOperations class before each test method is run.
 */
public abstract class BaseTest {

    /**
     * An instance of MathOperations class used to perform various mathematical operations in tests.
     */
    protected MathOperations mathOperations;

    /**
     * Initializes the MathOperations class instance before each test method.
     * This method is annotated with @BeforeMethod to ensure it runs before
     * each test method in the test classes.
     */
    @BeforeMethod
    protected void beforeMethod() {
        mathOperations = new MathOperations();
    }
}
