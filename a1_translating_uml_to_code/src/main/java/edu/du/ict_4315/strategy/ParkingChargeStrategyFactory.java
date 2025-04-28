package edu.du.ict_4315;

public class ParkingChargeStrategyFactory {

    public static ParkingChargeStrategy getStrategy(ParkingLot lot) {
        if (lot.getPricingStrat() instanceof HourlyCharge) {
            return new HourlyCharge();
        } else if (lot.getPricingStrat() instanceof DailyCharge) {
            return new DailyCharge();
        } 
    }
}
