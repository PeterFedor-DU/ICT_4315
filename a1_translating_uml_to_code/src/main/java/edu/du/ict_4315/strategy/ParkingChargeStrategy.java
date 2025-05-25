package edu.du.ict_4315.strategy;

import edu.du.ict_4315.parking.ParkingPermit;
import edu.du.ict_4315.money.Money;
import java.time.LocalDateTime;

public interface ParkingChargeStrategy {
    Money calculateCharge(ParkingPermit permit, LocalDateTime entryTime, LocalDateTime exitTime, Money baseRate);
}
