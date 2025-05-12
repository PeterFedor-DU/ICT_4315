package edu.du.ict4315.charges.decorator;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import edu.du.ict4315.parking.*;
import edu.du.ict4315.money.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompactCarDiscountDecoratorTest {

    @Test
    public void testCompactCarDiscount() {
        ParkingChargeCalculator base = new FlatRateCalculator();
        ParkingChargeCalculator decorated = new CompactCarDiscountDecorator(base);

        Car compactCar = new Car("DEDT14", CarType.COMPACT);
        ParkingPermit permit = new ParkingPermit("LOT1", compactCar);
        ParkingLot lot = new ParkingLot("L1");

        LocalDateTime entry = LocalDateTime.of(2025, 5, 4, 9, 0);
        LocalDateTime exit = LocalDateTime.of(2025, 5, 4, 17, 0);

        Money charge = decorated.getParkingCharge(entry, exit, lot, permit);
        assertEquals(new Money(8.00), charge);
    }

  
