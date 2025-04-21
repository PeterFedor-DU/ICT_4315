package edu.du.ict_4315.strategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

///MAking test data
public class DailyLotTest {
    private final Money baseRate = new Money(7.50);

    private Car testCar(CarType type) {
        return new Car("DEDT14", type, "Volkswagen", "GTI", "Iron blue");
    }

    private ParkingPermit makePermit(Car car) {
        return new ParkingPermit("C159", car);
    }

    private LocalDateTime makeEntry(int year, int month, int day, int hour) {
        return LocalDateTime.of(year, month, day, hour, 0);
    }

    private LocalDateTime makeExit(int year, int month, int day, int hour) {
        return LocalDateTime.of(year, month, day, hour, 30);
    }

@Test
    public void testMyCompactDiscount() {
        Car compactCar = makeCar(CarType.COMPACT);
        ParkingPermit permit = makePermit(compactCar);

        FlatRateWithVehicleTypeDiscount strategy = new FlatRateWithVehicleTypeDiscount();
        Money charge = strategy.calculateCharge(permit, makeEntry(2025, 4, 20, 9), makeExit(2025, 4, 20, 10), baseRate);

        assertEquals(new Money(8.00, "USD"), charge);
}

    @Test
    public void testSUVFullRate() {
        Car suv = makeCar(CarType.SUV);
        ParkingPermit permit = makePermit(suv);

        FlatRateWithVehicleTypeDiscount strategy = new FlatRateWithVehicleTypeDiscount();
        Money charge = strategy.calculateCharge(permit, makeEntry(2025, 4, 20, 9), makeExit(2025, 4, 20, 10), baseRate);

        assertEquals(baseRate, charge);
    }
