  // Server side (in some handler thread)
BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

// Read JSON
String inputJson = in.readLine();
ParkingRequest request = ParkingRequest.fromJson(inputJson);

// Process command (example only)
String message;
int status;
if ("CUSTOMER".equalsIgnoreCase(request.getCommand())) {
    String firstname = request.getParameters().getProperty("firstname");
    // Your logic to register customer here...
    message = "Customer " + firstname + " registered successfully!";
    status = 200;
} else {
    message = "Unknown command.";
    status = 400;
}

// Respond
ParkingResponse response = new ParkingResponse(status, message);
out.println(response.toJson());
