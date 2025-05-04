package edu.du.ict_4315;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class ParkingLot {
    private String lotId;
    private Address address;
    private int capacity;
    private List<Car> parkedCars;
    private ParkingChargeStrategy pricingStrat;
    private Money baseRate;

    private List<ParkingObserver> observers;

    public ParkingLot(String lotId, Address address, int capacity, ParkingChargeStrategy pricingStrat, Money baseRate) {
        this.lotId = lotId;
        this.address = address;
        this.capacity = capacity;
        this.parkedCars = new ArrayList<>();
        this.pricingStrat = pricingStrat;
        this.baseRate = baseRate;

        this.observers = new ArrayList<>();
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


            notifyObservers(new ParkingEvent(LocalDateTime.now(), car.getPermit(), this));
        } else {
            System.out.println("This car is not in the parking lot");
        }
    }


    public void addObserver(ParkingObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ParkingObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(ParkingEvent event) {
        for (ParkingObserver observer : observers) {
            observer.handleParkingEvent(event);
        }
    }

    public ParkingChargeStrategy getPricingStrat() {
        return pricingStrat;
    }

    public void setPricingStrat(ParkingChargeStrategy pricingStrat) {
        this.pricingStrat = pricingStrat;
    }

    public Money getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Money baseRate) {
        this.baseRate = baseRate;
    }

    public String toString() {
        return "ParkingLot [ID=" + lotId + ", Address=" + address.getAddressInfo() + ", Capacity=" + capacity + "]";
    }
}
