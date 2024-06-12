package ParametrizedTests.parametrizedOperandTests;

import io.qameta.allure.*;
import org.example.inputValidator.OperandValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.InputMismatchException;

@Epic("Epic: Basic Calculator Tests")
@Feature("Feature: Parametrized tests. Invalid Operand Validation")
public class InvalidOperandTest {

    /**
     * Provides invalid operands for testing.
     *
     * @return a 2D array containing invalid operands as strings.
     */

    @DataProvider(name = "invalidOperands")
    @Description("Provides invalid operands for testing")
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

    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that an InputMismatchException is thrown for invalid operands.")
    @Story("Invalid Operand Tests")
    @Step("Test invalid operand '{operand}'")
    @Test(dataProvider = "invalidOperands", expectedExceptions = InputMismatchException.class)
    public void testInvalidOperands(String operand) {
        OperandValidator.validateInputOperand(operand);
    }
}
