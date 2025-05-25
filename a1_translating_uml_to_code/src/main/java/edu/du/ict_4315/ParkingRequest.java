package edu.du.ict_4315;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Properties;

public class ParkingRequest {
    private String commandName;
    private Properties parameters;

    // Default constructor required for Gson
    public ParkingRequest() {
        this.parameters = new Properties();
    }

    public ParkingRequest(String commandName, Properties parameters) {
        this.commandName = commandName;
        this.parameters = parameters;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public Properties getParameters() {
        return parameters;
    }

    public void setParameters(Properties parameters) {
        this.parameters = parameters;
    }

    public String toJson() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    public static ParkingRequest fromJson(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, ParkingRequest.class);
    }

    @Override
    public String toString() {
        return "ParkingRequest{" +
                "commandName='" + commandName + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
