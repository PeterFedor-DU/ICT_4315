public class ParkingChargeStrategyFactory {

    public static StrategyInterface getStrategy(ParkingLot lot) {
        if (lot.isSpecialEvent()) {
            return new FlatRateStrategy();
        } else if (lot.isWeekend()) {
            return new WeekendDiscountStrategy();
        } else {
            return new HourlyRateStrategy();
        }
    }
}
