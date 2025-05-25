package edu.du.ict_4315

import com.google.gson.Gson;
import edu.du.ict4315.parking.model.ParkingRequest;
import edu.du.ict4315.parking.model.ParkingResponse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
    public static void main(String[] args) {
        int port = 4444;
        Gson gson = new Gson();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                ) {
                    String requestJson = in.readLine();
                    ParkingRequest request = gson.fromJson(requestJson, ParkingRequest.class);
                    System.out.println("Received: " + request);

                    ParkingResponse response = processRequest(request);
                    String responseJson = gson.toJson(response);

                    out.write(responseJson);
                    out.newLine();
                    out.flush();
                }
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ParkingResponse processRequest(ParkingRequest request) {
        String cmd = request.getCommand().toUpperCase();
        Properties props = request.getParameters();

        if ("CUSTOMER".equals(cmd)) {
            String firstName = props.getProperty("firstname");
            if (firstName != null) {
                // Imagine storing customer logic here
                return new ParkingResponse(200, "Customer " + firstName + " registered.");
            } else {
                return new ParkingResponse(400, "Missing parameter: firstname");
            }
        }

        if ("CAR".equals(cmd)) {
            String license = props.getProperty("license");
            String customerId = props.getProperty("customer");

            if (license != null && customerId != null) {
                // Imagine storing car logic here
                return new ParkingResponse(200, "Car " + license + " assigned to customer " + customerId);
            } else {
                return new ParkingResponse(400, "Missing license or customer parameter");
            }
        }

        return new ParkingResponse(404, "Unknown command: " + cmd);
    }
}
