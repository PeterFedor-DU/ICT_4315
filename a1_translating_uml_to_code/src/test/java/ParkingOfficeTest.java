package edu.du.ict_4315;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ParkingOfficeTest {

    private ParkingOffice parkingOffice;
    private Address address;
    private Customer customer1;
    @BeforeEach
    public void setUp() {
///Fake ParkingOffice and Address
        address = new Address("123 Denver St", "Denver", "CO", "80075");
        parkingOffice = new ParkingOffice("Downtown Parking", address);

///Registering a customer with a phone number
        customer1 = parkingOffice.register("Pete Fed", "303-765-4321", address, "303-765-4321");

        customer1.register("GOLF18", CarType.COMPACT);
    }

/// Test to see if the registration works
    @Test
    public void testRegisterCustomerAndCar() {
/// Verify customer registration
        assertNotNull(parkingOffice.getCustomer("Pete Fed"), "Customer should be registered");

/// Verify car registration and permit creation
        List<String> permitIds = parkingOffice.getPermitIds(customer1);
        assertTrue(permitIds.contains("GOLF18"), "Permit should be registered for car");
    }
}
