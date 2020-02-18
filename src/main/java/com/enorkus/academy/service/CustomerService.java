package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.MandatoryValueMissingException;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.validator.CustomerValidator;

import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerValidator customerValidator;

    public CustomerService() {
        customerRepository = new MemoryCustomerRepository();
        customerValidator = new CustomerValidator();
    }

    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    public void insertCustomer(Customer customer) {
        customerValidator.validateCustomer(customer);
        String formattedFirstName = capitalizeFirstLetter(customer.getFirstName());
        String formattedLastName = capitalizeFirstLetter(customer.getLastName());
        String formattedPersonalNumber = insertDashInNumber(customer.getPersonalNumber());
        Customer formattedCustomer = new Customer.CustomerBuilder(formattedFirstName, formattedLastName, formattedPersonalNumber)
                .middleName(customer.getMiddleName())
                .age(customer.getAge())
                .countryCode(customer.getCountryCode())
                .city(customer.getCity())
                .monthlyIncome(customer.getMonthlyIncome())
                .employer(customer.getEmployer())
                .gender(customer.getGender())
                .maritalStatus(customer.getMaritalStatus())
                .build();
        customerRepository.insert(formattedCustomer);
    }

    public void deleteCustomer(String customerID) {
        customerRepository.deleteById(customerID);
    }

    private String capitalizeFirstLetter(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    private String insertDashInNumber(String number) {
        if (number.length() > 3) {
            return number.substring(0, 4) + "-" + number.substring(4);
        }
        return number;
    }
}
