package edu.du.ict_4315

import java.util.Properties;

public class ParkingRequest {
    private String command;
    private Properties parameters;

    public ParkingRequest(String command, Properties parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    public String getCommand() {
        return command;
    }

    public Properties getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return "ParkingRequest [command=" + command + ", parameters=" + parameters + "]";
    }
}
