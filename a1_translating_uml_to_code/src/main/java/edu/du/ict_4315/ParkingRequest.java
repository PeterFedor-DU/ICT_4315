package edu.du.ict_4315;


import com.google.gson.Gson;
import java.util.Properties;

public class ParkingRequest {
    private String commandName;
    private Properties parameters;

    public ParkingRequest(String commandName, Properties parameters) {
        this.commandName = commandName;
        this.parameters = parameters;
    }

    public String getCommandName() {
        return commandName;
    }

    public Properties getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return "ParkingRequest{commandName='" + commandName + "', parameters=" + parameters + '}';
    }

    // Convert this object to JSON string
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Convert JSON string to ParkingRequest object
    public static ParkingRequest fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ParkingRequest.class);
    }
}
