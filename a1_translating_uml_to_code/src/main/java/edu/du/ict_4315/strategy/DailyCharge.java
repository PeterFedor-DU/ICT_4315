///Peter Fedor, ICT 4315, 4/20/2025
package edu.du.ict_4315.strategy;
import java.time.LocalDateTime;

public class DailyCharge implements ParkingChargeStrategy {

    private static final double Compact_Discount = 0.20;

    @Override
    public Money calculateCharge(ParkingPermit permit, LocalDateTime entryTime, LocalDateTime exitTime, Money baseRate) {
        Car car = permit.getCar();
        if (car.getType() == CarType.COMPACT) {
            return baseRate.multiply(1.0 - Compact_Discount);
        } else {
            return baseRate;
        }
    }
}
