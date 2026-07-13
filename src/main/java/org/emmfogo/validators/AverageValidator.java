package org.emmfogo.validators;

public class AverageValidator implements IValidator {
    @Override
    public boolean validateSpecial(String txt) {
        return !txt.isEmpty() && !txt.endsWith(" ");

    }

    @Override
    public boolean validateEmpty(String txt) {
        return !txt.isEmpty();
    }


}
