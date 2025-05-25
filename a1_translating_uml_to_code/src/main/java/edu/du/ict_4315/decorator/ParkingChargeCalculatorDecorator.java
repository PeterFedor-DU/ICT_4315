package edu.du.ict_4315.decorator;

import java.time.LocalDateTime;
import edu.du.ict4315.parking.ParkingLot;
import edu.du.ict4315.parking.ParkingPermit;
import edu.du.ict4315.money.Money;

public abstract class ParkingChargeCalculatorDecorator extends ParkingChargeCalculator {
    protected final ParkingChargeCalculator wrapped;

    public ParkingChargeCalculatorDecorator(ParkingChargeCalculator wrapped) {
        this.wrapped = wrapped;
    }
}
