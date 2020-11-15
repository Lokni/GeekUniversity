package Lesson_6_Web;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client implements Runnable {
    private Socket socket;
    private final String IP_ADDRESS = "localhost";
    private final int PORT = 8189;
    private Thread t1;
    private Thread t2;
    private DataInputStream in;
    private Scanner stdIn;
    private DataOutputStream out;
    private String serverMsg;
    private String clientMsg;

    public Client() {
        try {
            t1 = new Thread(this);
            t2 = new Thread(this);
            socket = new Socket(IP_ADDRESS, PORT);
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
            if (Thread.currentThread() == t2) {
                do {
                    clientMsg = stdIn.nextLine();
                    out.writeUTF(clientMsg);
                } while (!clientMsg.equalsIgnoreCase("/end"));
            } else {
                do {
                serverMsg = in.readUTF();
                System.out.println("Server: " + serverMsg);
                } while (!serverMsg.equalsIgnoreCase("/end"));
            }
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (NullPointerException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
