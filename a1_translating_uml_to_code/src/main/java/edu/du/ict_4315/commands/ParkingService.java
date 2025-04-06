import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ParkingService {
    private ParkingOffice office;
    private Map<String, Command> commands = new HashMap<>();

    public ParkingService(ParkingOffice office) {
        this.office = office;
    }

    public void register(Command cmd) {
        commands.put(cmd.getCommandName(), cmd);
    }

    public String performCommand(String name, String[] args) {
        Command cmd = commands.get(name);
        if (cmd == null) return "Not a valid input";

        Properties props = new Properties();
        for (String arg : args) {
            String[] keyValue = arg.split("=");
            props.setProperty(keyValue[0], keyValue[1]);
        }

        return cmd.execute(props);
    }
}
