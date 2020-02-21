package com.enorkus.academy.validator;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.ValidationException;

public class MandatoryValueValidator extends Validator<Customer> {

    @Override
    public void validate(Customer attribute, String message) {
        if (isStringEmpty(attribute.getFirstName())) {
            throw new ValidationException(message + "\n" + "First name is mandatory!");
        }
        if (isStringEmpty(attribute.getLastName())) {
            throw new ValidationException(message + "\n" + "Last name is mandatory!");
        }
        if (isStringEmpty(attribute.getPersonalNumber())) {
            throw new ValidationException(message + "\n" + "Personal number is mandatory!");
        }
        checkIfMandatoryValuesAreValid(attribute, message);
    }

    private void checkIfMandatoryValuesAreValid(Customer attribute, String message) {
        if (!doesStringContainLetters(attribute.getFirstName())) {
            throw new ValidationException(message + "\n" + "First name must contain letters only.");
        }
        if (!doesStringContainLetters(attribute.getLastName())) {
            throw new ValidationException(message + "\n" + "Last name must contain letters only.");
        }
        if (!doesStringContainNumbers(attribute.getPersonalNumber())) {
            throw new ValidationException(message + "\n" + "Personal number must contain numbers only.");
        }
    }

    private boolean isStringEmpty(String string) {
        return string.trim().length() == 0;
    }

    private boolean doesStringContainLetters(String word) {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean doesStringContainNumbers(String word) {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
