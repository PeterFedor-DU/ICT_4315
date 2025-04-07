package edu.du.ict_4315.commands;
///todo - update entire code to fit into github so imports are correctly defined
import edu.du.ict_4315.*
import java.util.Properties;

///Class for the command to register a car
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
        String customerId = parameters.getProperty("customerId");
        String name = parameters.getProperty("name");
        String phone = parameters.getProperty("phoneNumber");
        String street = parameters.getProperty("street");
        String city = parameters.getProperty("city");
        String state = parameters.getProperty("state");
        String zip = parameters.getProperty("zip");

        // Check if any required parameter is missing
        if (customerId == null || name == null || phone == null || street == null || city == null || state == null || zip == null) {
            return "Missing parameters. Required: customerId, name, phoneNumber, street, city, state, zip";
        }

        // Create the address and register the customer
        Address address = new Address(street, city, state, zip);
        Customer customer = office.register(customerId, name, address, phone);

        // Return success message with customer info
        return "Customer registered: " + customer.getCustomerId() + " - " + customer.getName();
    }
}
