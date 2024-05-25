package ParametrizedTests.parametrizedOperandTests;

import org.example.inputValidator.OperandValidator;
import org.example.inputValidator.OperatorValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidOperandTest {

    /**
     * Provides valid operands for testing.
     *
     * @return a 2D array containing valid operands as strings.
     */

    @DataProvider(name = "validOperands")
    public Object[][] validOperands() {
        return new Object[][]{
                { "123" },
                { "-525" },
                { "+3578" },
                {"65785566"},
                { "0" }
        };
    }

    /**
     * Tests valid operands.
     *
     * @param operand the operand to be validated as a string
     */

    @Test(dataProvider = "validOperands")
    public void testValidOperands(String operand) {
        OperandValidator.validateInputOperand(operand);
    }
}
