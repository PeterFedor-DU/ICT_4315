package edu.du.ict4315.decorator;

import java.time.LocalDateTime;
import edu.du.ict4315.parking.ParkingLot;
import edu.du.ict4315.parking.ParkingPermit;
import edu.du.ict4315.parking.CarType;
import edu.du.ict4315.money.Money;

public class CompactCarDiscountDecorator extends ParkingChargeCalculatorDecorator {

    public CompactCarDiscountDecorator(ParkingChargeCalculator wrapped) {
        super(wrapped);
    }

    @Override
    public Money getParkingCharge(LocalDateTime entryTime, LocalDateTime exitTime,
                                  ParkingLot lot, ParkingPermit permit) {
        Money baseCharge = wrapped.getParkingCharge(entryTime, exitTime, lot, permit);
        if (permit.getCar().getType() == CarType.COMPACT) {
            return baseCharge.multiply(0.80); // 20% discount
        }
        return baseCharge;
    }
}
