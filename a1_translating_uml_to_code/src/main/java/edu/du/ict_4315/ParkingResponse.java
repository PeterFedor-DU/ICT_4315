package edu.du.ict_4315


import com.google.gson.Gson;

public class ParkingResponse {
    private int statusCode;
    private String message;

    public ParkingResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ParkingResponse{statusCode=" + statusCode + ", message='" + message + "'}";
    }

    // Convert this object to JSON string
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Convert JSON string to ParkingResponse object
    public static ParkingResponse fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ParkingResponse.class);
    }
}
