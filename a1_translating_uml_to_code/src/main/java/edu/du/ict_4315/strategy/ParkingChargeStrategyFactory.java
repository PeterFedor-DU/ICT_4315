package edu.du.ict_4315.strategy;

public class ParkingChargeStrategyFactory {

    public static ParkingChargeStrategy getStrategy(ParkingLot lot) {
///Seeing if the lot has a strategy set
        if (lot.getPricingStrat() != null) {
            return lot.getPricingStrat();
        }

///Setting hourly charge as the default if nothing is returned
        return new HourlyCharge();
    }
}
