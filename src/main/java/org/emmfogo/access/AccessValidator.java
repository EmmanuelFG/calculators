package org.emmfogo.access;

public class AccessValidator implements IAccess {
    @Override
    public boolean validate(String calculatorType, String role) {
        return (calculatorType.equals("Standar calculator") && role.equals("student")) ||
                (calculatorType.equals("Average calculator") && role.equals("teacher"));
    }
}
