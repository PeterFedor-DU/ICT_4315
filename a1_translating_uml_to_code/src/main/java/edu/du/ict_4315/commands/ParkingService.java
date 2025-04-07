package edu.du.ict_4315.commands;

import edu.du.ict_4315.ParkingOffice
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

///Creating Parking Service class
public class ParkingService {
    private ParkingOffice office;
    private Map<String, Command> commands;

    public ParkingService(ParkingOffice office) {
        this.office = office;
        this.commands = new HashMap<>();
    }

    public void register(Command command) {
        commands.put(command.getCommandName(), command);
    }

    public String performCommand(String commandName, String[] parameters) {
        Command command = commands.get(commandName);
        if (command == null) return "Unknown command: " + commandName;

        Properties props = new Properties();
        for (String param : parameters) {
            String[] keyValue = param.split("=", 2);
            if (keyValue.length == 2) {
                props.setProperty(keyValue[0], keyValue[1]);
            }
        }

        return command.execute(props);
    }
}
