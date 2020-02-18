package com.enorkus.academy.validator;

import com.enorkus.academy.entity.Customer;

public class CustomerValidator {
    private MandatoryValueValidator mandatoryValueValidator;
    private CustomerAdultValidator customerAdultValidator;
    private CountryCodeValidator countryCodeValidator;

    public CustomerValidator() {
        mandatoryValueValidator = new MandatoryValueValidator();
        customerAdultValidator = new CustomerAdultValidator();
        countryCodeValidator = new CountryCodeValidator();
    }

    public void validateCustomer(Customer customer) {
        mandatoryValueValidator.validate(customer, "Mandatory value is missing!");
        customerAdultValidator.validate(customer, "Customer must be 18 or older!");
        countryCodeValidator.validate(customer, "Invalid country code!");
    }
}
