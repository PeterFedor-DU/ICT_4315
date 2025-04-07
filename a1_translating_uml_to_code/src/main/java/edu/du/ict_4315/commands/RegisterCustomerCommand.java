package edu.du.ict_4315.commands;

import edu.du.ict_4315.*
import java.util.Properties;

public class RegisterCustomerCommand implements Command {
    private ParkingOffice office;

    public RegisterCustomerCommand(ParkingOffice office) {
        this.office = office;
    }

    @Override
    public String getCommandName() {
        return "CUSTOMER";
    }

    @Override
    public String getDisplayName() {
        return "Register a Customer";
    }

    @Override
    public String execute(Properties parameters) {
        String id = parameters.getProperty("customerId");
        String name = parameters.getProperty("name");
        String phone = parameters.getProperty("phoneNumber");
        Address address = new Address(
            parameters.getProperty("street"),
            parameters.getProperty("city"),
            parameters.getProperty("state"),
            parameters.getProperty("zip")
        );

        Customer customer = office.register(id, name, address, phone);
        return "Customer registered: " + customer.getCustomerId();
    }
}
