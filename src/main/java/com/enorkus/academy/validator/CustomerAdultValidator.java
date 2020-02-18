package com.enorkus.academy.validator;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.ValidationException;

public class CustomerAdultValidator extends Validator<Customer> {

    @Override
    public void validate(Customer attribute, String message) {
        if (attribute.getAge() < 18) {
            throw new ValidationException(message);
        }
    }
}
