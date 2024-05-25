package ParametrizedTests.parametrizedOperandTests;

import org.example.inputValidator.OperandValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.InputMismatchException;

public class InvalidOperandTest {

    /**
     * Provides invalid operands for testing.
     *
     * @return a 2D array containing invalid operands as strings.
     */

    @DataProvider(name = "invalidOperands")
    public Object[][] invalidOperands() {
        return new Object[][]{
                {"25a"},
                {"-12.3"},
                {"abc"},
                {"a"},
                {"5.6"},
                {"-653a"}
        };
    }

    /**
     * Tests invalid operands.
     *
     * @param operand the operand to be validated as a string
     * @throws InputMismatchException expected exception for invalid operands
     */

    @Test(dataProvider = "invalidOperands", expectedExceptions = InputMismatchException.class)
    public void testInvalidOperands(String operand) {
        OperandValidator.validateInputOperand(operand);
    }
}
