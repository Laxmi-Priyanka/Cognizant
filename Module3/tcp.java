import java.io.*;
import java.net.*;

public class TCPChatServer {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String messageFromClient, messageToClient;

            while (true) {
                messageFromClient = input.readLine();
                if (messageFromClient.equalsIgnoreCase("exit")) break;
                System.out.println("Client: " + messageFromClient);

                System.out.print("You: ");
                messageToClient = console.readLine();
                output.println(messageToClient);
                if (messageToClient.equalsIgnoreCase("exit")) break;
            }
