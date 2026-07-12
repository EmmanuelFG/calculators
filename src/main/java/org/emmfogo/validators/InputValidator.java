package org.emmfogo.validators;

public class InputValidator implements IValidator {
    @Override
    public boolean validate(String calculatorType, String role) {
        return (calculatorType.equals("Standar calculator") && role.equals("student")) ||
                (calculatorType.equals("Average calculator") && role.equals("teacher"));
    }
}
