package com.enorkus.academy.controller;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private CustomerService customerService;

    public MainController() {
        customerService = new CustomerService();
    }

    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers() {
        return customerService.fetchCustomers();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }

    /*@RequestMapping("/strings")
    public List<Car> getStrings() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("audi",100,"red",false, Arrays.asList()));
        //strings.add("Pirmas");
        //strings.add("Antras");
        return cars;
    }

    public class Car{
        private String model;
        private int speed;
        private String color;
        private boolean isFast;
        private List<String> modifications;

        public Car(String model, int speed, String color, boolean isFast, List<String> modifications) {
            this.model = model;
            this.speed = speed;
            this.color = color;
            this.isFast = isFast;
            this.modifications = modifications;
        }

        public String getModel() {
            return model;
        }

        public int getSpeed() {
            return speed;
        }

        public String getColor() {
            return color;
        }

        public boolean isFast() {
            return isFast;
        }

        public List<String> getModifications() {
            return modifications;
        }
    }*/
}