package edu.du.ict_4315;

import java.util.Calendar;

public class ParkingPermit {
    private String id;
    private Car car;
    private Calendar expirationDate;
    private Calendar registrationDate;

    public ParkingPermit(String id, Car car) {
        this.id = id;
        this.car = car;
        this.registrationDate = Calendar.getInstance();
        this.expirationDate = (Calendar) registrationDate.clone();
        this.expirationDate.add(Calendar.YEAR, 1); 
    }

    public String getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public Calendar getRegistrationDate() {
        return registrationDate;
    }
}
