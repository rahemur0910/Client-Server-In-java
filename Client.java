import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server
            Socket clientSocket = new Socket("localhost", 12345);

            // Open input and output streams for communication with the server
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read messages from the console and send them to the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while ((message = reader.readLine()) != null) {
                // Send message to the server
                outToServer.println(message);

                // Receive response from the server and print it
                String response = inFromServer.readLine();
                System.out.println("Server: " + response);
            }

            // Close resources
            reader.close();
            inFromServer.close();
            outToServer.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
