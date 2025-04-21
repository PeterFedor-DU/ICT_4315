///Peter Fedor, ICT 4315, 4/20/2025
package edu.du.ict_4315.strategy;
import java.time.LocalDateTime;

public class FlatRateWithVehicleTypeDiscount implements ParkingChargeStrategy {

    private static final double COMPACT_DISCOUNT = 0.20;

    @Override
    public Money calculateCharge(ParkingPermit permit, LocalDateTime entryTime, LocalDateTime exitTime, Money baseRate) {
        Car car = permit.getCar();
        if (car.getType() == CarType.COMPACT) {
            return baseRate.multiply(1.0 - COMPACT_DISCOUNT);
        } else {
            return baseRate;
        }
    }
}
