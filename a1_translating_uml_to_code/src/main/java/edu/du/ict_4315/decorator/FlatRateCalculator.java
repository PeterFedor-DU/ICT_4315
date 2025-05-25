package edu.du.ict_4315.decorator;

import java.time.LocalDateTime;
import edu.du.ict4315.parking.ParkingLot;
import edu.du.ict4315.parking.ParkingPermit;
import edu.du.ict4315.money.Money;

public class FlatRateCalculator extends ParkingChargeCalculator {

    private static final Money FLAT_RATE = new Money(10.00);

    @Override
    public Money getParkingCharge(LocalDateTime entryTime, LocalDateTime exitTime,
                                  ParkingLot lot, ParkingPermit permit) {
        return FLAT_RATE;
    }
}
