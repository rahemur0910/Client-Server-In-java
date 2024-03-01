import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a ServerSocket object
            ServerSocket serverSocket = new ServerSocket(12345);

            System.out.println("Server started. Waiting for clients to connect...");

            // Accept client connections
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected: " + clientSocket);

            // Open input and output streams for communication with the client
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read messages from the client and print them
            String messageFromClient;
            while ((messageFromClient = inFromClient.readLine()) != null) {
                System.out.println("Client: " + messageFromClient);

                // Echo the message back to the client
                outToClient.println("Server received: " + messageFromClient);
            }

            // Close resources
            inFromClient.close();
            outToClient.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
