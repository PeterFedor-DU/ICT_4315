package edu.du.ict_4315;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    public void testRegisterCar() {
        Customer customer = new Customer("CUST1", "Peter Fedor", new Address("123 Wadsworth Blvd", "Westminster", "CO", "80021"), "303-333-3333");
        Car car = customer.register("1234XYZ", CarType.COMPACT);
        assertNotNull(car);
    }
}
