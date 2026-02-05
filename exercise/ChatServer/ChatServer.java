import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static HashMap<String, PrintWriter> clients = new HashMap<>();
    private static int userIdCounter = 1;

    public static void main(String[] args) {
        System.out.println("Chat Server is running...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept(), "User" + userIdCounter++).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + PORT);
            System.exit(1);
        }
    }

    // ClientHandler class to manage each client connection
    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String userId;

        public ClientHandler(Socket socket, String userId) {
            this.socket = socket;
            this.userId = userId;
        }

        public void run() {
            try {
                // Initialize input and output streams
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Add client to the list
                synchronized (clients) {
                    clients.put(userId, out);
                }
                broadcast(userId + " has joined the chat!");

                // Handle client messages
                String message;
                while ((message = in.readLine()) != null) {
                    if (!message.isEmpty()) {
                        broadcast(userId + ": " + message);
                    }
                }
            } catch (IOException e) {
                System.out.println(userId + " disconnected");
            } finally {
                // Remove client on disconnection
                if (userId != null) {
                    synchronized (clients) {
                        clients.remove(userId);
                    }
                    broadcast(userId + " has left the chat!");
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket");
                }
            }
        }

        // Broadcast message to all clients
        private void broadcast(String message) {
            synchronized (clients) {
                for (PrintWriter client : clients.values()) {
                    client.println(message);
                }
            }
        }
    }
}
