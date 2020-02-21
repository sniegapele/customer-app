package com.enorkus.academy.validator;

import com.enorkus.academy.entity.CountryCodes;
import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.ValidationException;

public class CountryCodeValidator extends Validator<String> {

    @Override
    public void validate(String attribute, String message) {
        String countryCode = attribute.trim().toUpperCase();
        if (countryCode.length() > 0) {
            for (CountryCodes code : CountryCodes.values()) {
                if (countryCode.equals(code.toString())) {
                    return;
                }
            }
            throw new ValidationException(message);
        }
    }
}
