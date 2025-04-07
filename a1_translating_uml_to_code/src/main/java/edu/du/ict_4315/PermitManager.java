package edu.du.ict_4315

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermitManager {
    private HashMap<String, ParkingPermit> permits;

    public PermitManager() {
        this.permits = new HashMap<>();
    }


    public ParkingPermit register(Car car) {
        String permitId = "PERMIT-" + car.getLicense();
        if (permits.containsKey(permitId)) {
            return permits.get(permitId);  
        }

        ParkingPermit permit = new ParkingPermit(permitId, car);
        permits.put(permitId, permit);
        return permit;
    }

    public List<String> getAllPermitIds() {
        return new ArrayList<>(permits.keySet());
    }


    public List<String> getPermitIdsByCustomer(Customer customer) {
        List<String> permitIds = new ArrayList<>();
        for (ParkingPermit permit : permits.values()) {
            if (permit.getCar().getOwner().equals(customer)) {
                permitIds.add(permit.getId());
            }
        }
        return permitIds;
    }
}
