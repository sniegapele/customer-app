package com.enorkus.academy.validator;

import com.enorkus.academy.entity.CountryCodes;
import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.ValidationException;

public class CountryCodeValidator extends Validator<Customer> {

    @Override
    public void validate(Customer attribute, String message) {
        String countryCode = attribute.getCountryCode().trim().toUpperCase();
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
