package edu.du.ict_4315.commands;
///todo - update entire code to fit into github so imports are correctly defined
import edu.du.ict_4315.*;
import java.util.Properties;
///Class for the command to register a car
public class RegisterCarCommand implements Command {
    private ParkingOffice office;

    public RegisterCarCommand(ParkingOffice office) {
        this.office = office;
    }

    @Override
    public String execute(String[] args) {
        if (args.length < 4) {
            return "Error: Missing parameters. Expected: license carType firstName lastName";
        }

        String license = args[0];
        String carTypeStr = args[1];
        String firstName = args[2];
        String lastName = args[3];

        CarType carType;
        try {
            carType = CarType.valueOf(carTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            return "Error: Invalid car type. Use 'COMPACT' or 'SUV'.";
        }

        Customer customer = office.findCustomer(firstName, lastName);
        if (customer == null) {
            return "Error: Customer not found.";
        }

        Car car = new Car(license, carType, customer);
        ParkingPermit permit = office.register(car);
        return "Car registered. Permit ID: " + permit.getId();
    }
}
