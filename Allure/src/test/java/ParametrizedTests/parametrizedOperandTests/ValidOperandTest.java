package ParametrizedTests.parametrizedOperandTests;

import io.qameta.allure.*;
import org.example.inputValidator.OperandValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Parametrized tests. Valid Operand Validation")
public class ValidOperandTest {

    /**
     * Provides valid operands for testing.
     *
     * @return a 2D array containing valid operands as strings.
     */

    @DataProvider(name = "validOperands")
    @Description("Provides valid operands for testing")
    public Object[][] validOperands() {
        return new Object[][]{
                {"123"},
                {"-525"},
                {"+3578"},
                {"65785566"},
                {"0"}
        };
    }

    /**
     * Tests valid operands.
     *
     * @param operand the operand to be validated as a string
     */

    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that valid operands are correctly validated.")
    @Story("Valid Operand Tests")
    @Step("Test valid operand '{operand}'")
    @Test(dataProvider = "validOperands")
    public void testValidOperands(String operand) {
        OperandValidator.validateInputOperand(operand);
    }
}
