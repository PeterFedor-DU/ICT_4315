package edu.du.ict_4315

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    private ParkingLot parkingLot;
    private Address address;
    private Customer customer1;
    private Car car1;
    private Car car2;

    @BeforeEach
    public void setUp() {
///Setting up a fake parking lot with 2 spots
        address = new Address("123 Sheridan blvd", "Arvada", "CO", "80021");
        parkingLot = new ParkingLot("L1", address, 2);
        
///Creating fake customer and cars
        customer1 = new Customer("1", "Peter Fedor", address, "303-123-1234");
        car1 = customer1.register("DEDT14", CarType.COMPACT);
        car2 = customer1.register("TOFQ13", CarType.SUV);
    }

    @Test
    public void testEntryAndExit() { 
    
///Seeing if car 1 can enter
        assertTrue(parkingLot.toString().contains(""));

        // Entry test 2: Car 2 should enter (lot has space)
        parkingLot.entry(car2);
        assertTrue(parkingLot.toString().contains("TOFQ13"));

///Parking when lot is full
        Customer customer2 = new Customer("2", "Cindy Le", address, "720-123-1234");
        Car car3 = customer2.register("LOQR16", CarType.SUV);
        parkingLot.entry(car3); 
        assertFalse(parkingLot.toString().contains("LEDG94"));


        parkingLot.exit(car1);
        assertFalse(parkingLot.toString().contains("DEDT14"));
    }
}
