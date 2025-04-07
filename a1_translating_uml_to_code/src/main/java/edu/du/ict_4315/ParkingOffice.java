package edu.du.ict_4315

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ParkingOffice {
    private String parkingOfficeName;
    private List<Customer> customers;
    private List<ParkingLot> parkingLots;
    private PermitManager permitManager;
    private TransactionManager transactionManager;

    public ParkingOffice(String name, Address address) {
        this.parkingOfficeName = name;
        this.customers = new ArrayList<>();
        this.parkingLots = new ArrayList<>();
        this.permitManager = new PermitManager();
        this.transactionManager = new TransactionManager();
    }

    public String getParkingOfficeName() {
        return parkingOfficeName;
    }

    public Customer register(String customerId, String name, Address address, String phoneNumber) {
        Customer customer = new Customer(customerId, name, address, phoneNumber);
        customers.add(customer);
        return customer;
    }

    public ParkingPermit register(Car car) {
        return permitManager.register(car);
    }

    public ParkingTransaction park(Calendar date, ParkingPermit permit, ParkingLot lot) {
        return transactionManager.park(date, permit, lot);
    }

    public Money getParkingCharges(ParkingPermit permit) {
        return transactionManager.getParkingCharges(permit);
    }

    public Money getParkingCharges(Customer customer) {
        return transactionManager.getParkingCharges(customer);
    }

    public void addParkingLot(ParkingLot lot) {
        if (!parkingLots.contains(lot)) {
            parkingLots.add(lot);
        }
    }

    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null; 
    }

    public List<String> getCustomerIds() {
        List<String> customerIds = new ArrayList<>();
        for (Customer customer : customers) {
            customerIds.add(customer.getCustomerId());
        }
        return customerIds;
    }
    
    public List<String> getPermitIds() {
        return permitManager.getAllPermitIds();
    }
    
    public List<String> getPermitIds(Customer customer) {
        return permitManager.getPermitIdsByCustomer(customer);
    } 
}
