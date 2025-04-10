package edu.du.ict_4315


import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String lotId;
    private Address address;
    private int capacity;
    private List<Car> parkedCars;  

    public ParkingLot(String lotId, Address address, int capacity) {
        this.lotId = lotId;
        this.address = address;
        this.capacity = capacity;
        this.parkedCars = new ArrayList<>();
    }


    public void entry(Car car) {
        if (parkedCars.size() < capacity) {
            parkedCars.add(car);
            System.out.println("Car entered: " + car);
        } else {
            System.out.println("Parking Lot is full. Cannot park the car.");
        }
    }


    public void exit(Car car) {
        if (parkedCars.contains(car)) {
            parkedCars.remove(car);
            System.out.println("Car has exited: " + car);
        } else {
            System.out.println("This car is not in the parking lot");
            }
        }
        
        public String toString() {
            return "ParkingLot [ID=" + lotId + ", Address=" + address.getAddressInfo() + ", Capacity=" + capacity + "]";
        }


	
}
