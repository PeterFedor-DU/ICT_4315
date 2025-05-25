package edu.du.ict_4315.decorator;

import java.time.LocalDateTime;
import edu.du.ict4315.parking.ParkingLot;
import edu.du.ict4315.parking.ParkingPermit;
import edu.du.ict4315.money.Money;

public abstract class ParkingChargeCalculator {
    public abstract Money getParkingCharge(LocalDateTime entryTime, LocalDateTime exitTime,
                                           ParkingLot lot, ParkingPermit permit);
}
