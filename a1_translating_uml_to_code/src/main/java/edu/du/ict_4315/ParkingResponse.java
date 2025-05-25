package edu.du.ict_4315

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
        return "ParkingResponse [statusCode=" + statusCode + ", message=" + message + "]";
    }
}
