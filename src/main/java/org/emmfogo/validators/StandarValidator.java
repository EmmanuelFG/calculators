package org.emmfogo.validators;

public class StandarValidator implements IValidator {
    @Override
    public boolean validateSpecial(String txt) {
        return !txt.endsWith("+") && !txt.endsWith("-") && !txt.endsWith("*") && !txt.endsWith("/") && !txt.isEmpty();
    }

    @Override
    public boolean validateEmpty(String txt) {
        return !txt.isEmpty();
    }
}
