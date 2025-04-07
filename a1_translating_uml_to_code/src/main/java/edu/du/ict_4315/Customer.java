package edu.du.ict_4315

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private String customerId;
    private String name;
    private Address address; 
    private String phoneNumber;
    private List<Car> cars;


    public Customer(String customerId, String name, Address address, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cars = new ArrayList<>();
    }

///Register a new car for the customer
    public Car register(String license, CarType type) {
        Car newCar = new Car("P" + license, LocalDate.now().plusYears(1), license, type, this); 
        cars.add(newCar);
        return newCar;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }


    public String toString() {
        return "Customer [ID=" + customerId + ", Name=" + name + ", Address=" + address.getAddressInfo() + ", Phone=" + phoneNumber + "]";
    }

  
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

   
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
