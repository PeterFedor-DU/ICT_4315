package edu.du.ict_4315;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotObserverTest {

    private ParkingLot parkingLot;
    private TransactionManager transactionManager;
    private Car car;
    private ParkingPermit permit;

    @BeforeEach
    public void setup() {
        Address address = new Address("1111 Asbury St", "Denver", "CO", "80210");
        Money baseRate = new Money(10.00);
        ParkingChargeStrategy strategy = new DailyCharge(); 

        parkingLot = new ParkingLot("LOT-001", address, 10, strategy, baseRate);
        transactionManager = new TransactionManager();

        parkingLot.addObserver(transactionManager);

        Customer customer = new Customer("cust-01", "Peter Fedor", address);
        car = new Car("DEDT14", CarType.Compact);
        permit = new ParkingPermit("permit-001", car, customer, Calendar.getInstance());
        car.setPermit(permit);
    }

    @Test
    public void testObserverReceivesExitEvent() {
        parkingLot.entry(car);
        parkingLot.exit(car); 


        Money charges = transactionManager.getParkingCharges(permit);
        assertTrue(charges.getAmount() > 0, "Charge should be greater than 0 after parking event.");
    }

    @Test
    public void testObserverNotRegistered_NoTransactionLogged() {

        Address address = new Address("456 Broadway", "Denver", "CO", "80203");
        ParkingLot unobservedLot = new ParkingLot("LOT-002", address, 5, new FlatRateStrategy(), new Money(8.00));

        unobservedLot.entry(car);
        unobservedLot.exit(car); 

        Money charges = transactionManager.getParkingCharges(permit);
        assertEquals(0.0, charges.getAmount(), "No charges should be logged if observer wasn't registered.");
    }

    @Test
    public void testAddAndRemoveObserver() {
        parkingLot.removeObserver(transactionManager);

        parkingLot.entry(car);
        parkingLot.exit(car); 

        Money charges = transactionManager.getParkingCharges(permit);
        assertEquals(0.0, charges.getAmount(), "No charges expected after observer was removed.");
    }
}
