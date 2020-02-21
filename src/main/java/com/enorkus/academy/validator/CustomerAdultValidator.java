package com.enorkus.academy.validator;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.ValidationException;

public class CustomerAdultValidator extends Validator<Integer> {

    @Override
    public void validate(Integer attribute, String message) {
        if (attribute < 18) {
            throw new ValidationException(message);
        }
    }
}
