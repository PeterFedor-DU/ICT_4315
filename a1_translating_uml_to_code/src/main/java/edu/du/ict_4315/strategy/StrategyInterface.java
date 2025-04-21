///Peter Fedor, ICT 4315, 4/20/2025
package edu.du.ict_4315.strategy;
import java.time.LocalDateTime;


///Creating a strategy interface 
public interface ParkingChargeStrategy {
    Money calculateCharge(ParkingPermit permit, LocalDateTime entryTime, LocalDateTime exitTime, Money baseRate);
}
