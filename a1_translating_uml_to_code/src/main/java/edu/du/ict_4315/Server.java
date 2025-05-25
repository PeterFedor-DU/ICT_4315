package edu.du.ict4315.parking.server;

import com.google.gson.Gson;
import edu.du.ict4315.parking.protocol.ParkingRequest;
import edu.du.ict4315.parking.protocol.ParkingResponse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
    private static final int PORT = 4444;

    public static void main(String[] args) {
        System.out.println("Starting server on port " + PORT + "...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    // Read input JSON
                    String inputLine = in.readLine();
                    System.out.println("Received JSON: " + inputLine);

                    // Deserialize the request
                    ParkingRequest request = ParkingRequest.fromJson(inputLine);
                    String command = request.getCommandName();
                    Properties props = request.getParameters();

                    // Handle the command
                    ParkingResponse response;
                    if ("CUSTOMER".equalsIgnoreCase(command)) {
                        String firstName = props.getProperty("firstname");
                        String lastName = props.getProperty("lastname");
                        String phone = props.getProperty("phone");
                        // TODO: Register customer logic here
                        response = new ParkingResponse(200, "Customer registered: " + firstName + " " + lastName);
                    } else if ("CAR".equalsIgnoreCase(command)) {
                        String license = props.getProperty("license");
                        String state = props.getProperty("state");
                        String make = props.getProperty("make");
                        // TODO: Register car logic here
                        response = new ParkingResponse(200, "Car registered: " + license);
                    } else {
                        response = new ParkingResponse(400, "Unknown command: " + command);
                    }

                    // Send JSON response
                    String jsonResponse = response.toJson();
                    out.println(jsonResponse);
                    System.out.println("Sent response: " + jsonResponse);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    clientSocket.close();
                    System.out.println("Connection closed.");
                }
            }

        } catch (IOException e) {
            System.err.println("Could not start server: " + e.getMessage());
        }
    }
}
