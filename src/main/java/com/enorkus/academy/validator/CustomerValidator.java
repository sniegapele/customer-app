package com.enorkus.academy.validator;

import com.enorkus.academy.entity.Customer;

public class CustomerValidator {
    private MandatoryValueValidator mandatoryValueValidator;
    private CustomerAdultValidator customerAdultValidator;
    private CountryCodeValidator countryCodeValidator;

    public void validateCustomer(Customer customer) {
        mandatoryValueValidator = new MandatoryValueValidator();
        mandatoryValueValidator.validate(customer, "Mandatory value is missing!");
        customerAdultValidator = new CustomerAdultValidator();
        customerAdultValidator.validate(customer.getAge(), "Customer must be 18 or older!");
        countryCodeValidator = new CountryCodeValidator();
        countryCodeValidator.validate(customer.getCountryCode(), "Invalid country code!");
    }
}
