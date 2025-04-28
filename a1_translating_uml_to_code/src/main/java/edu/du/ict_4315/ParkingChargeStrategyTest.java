package edu.du.ict_4315;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ParkingChargeStrategyFactoryTest {

    @Test
    void testGetStrategyForHourlyCharge() {
        ParkingLot lot = new ParkingLot("A1", new Address("123 Street"), 50);
        lot.setPricingStrat(new HourlyCharge());
        ParkingChargeStrategy strategy = ParkingChargeStrategyFactory.getStrategy(lot);
        assertTrue(strategy instanceof HourlyCharge);
    }

    @Test
    void testGetStrategyForDailyCharge() {
        ParkingLot lot = new ParkingLot("B1", new Address("456 Avenue"), 100);
        lot.setPricingStrat(new DailyCharge());
        ParkingChargeStrategy strategy = ParkingChargeStrategyFactory.getStrategy(lot);
        assertTrue(strategy instanceof DailyCharge);
    }
}
