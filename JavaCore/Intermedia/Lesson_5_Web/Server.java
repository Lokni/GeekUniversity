package Lesson_6_Web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {
    // Add variables for server methods.
    private ServerSocket server;
    private Socket socket;
    // Prepare threads for input/output thread.
    private Thread t1;
    private Thread t2;
    // Prepare Read methods for change messages between server and user.
    private DataInputStream in;
    private Scanner stdIn;
    private DataOutputStream out;
    // String variables for output methods.
    private String serverMsg;
    private String clientMsg;

    public Server() {
        int PORT = 8189;
        try {
            // Initialize threads.
            t1 = new Thread(this);
            t2 = new Thread(this);
            // Start server.
            server = new ServerSocket(PORT);
            System.out.println("Server ready!");
            // Connecting client on socket.
            socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());
            // Start threads.
            t1.start();
            t2.start();

        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void run() {
        try {
            in = new DataInputStream(socket.getInputStream());
            stdIn = new Scanner(System.in);
            out = new DataOutputStream(socket.getOutputStream());
            out.flush();
            if (Thread.currentThread() == t1) {
                do {
                    serverMsg = stdIn.nextLine(); // readLine() работает ОК.
                    out.writeUTF(serverMsg);

                } while (!serverMsg.equalsIgnoreCase("/end"));
            } else {
                do {
                    clientMsg = in.readUTF();
                    System.out.println("Client: " + clientMsg);
                } while (!clientMsg.equalsIgnoreCase("/end"));
            }

        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
                server.close();
            } catch (NullPointerException | IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Server();
    }
}

