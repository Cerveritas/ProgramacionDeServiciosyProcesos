package Chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class ClienteSocketStream {

        public static void main(String[] args) {

            String serverIP = "10.230.163.211";
            int serverPort = 5555;

            try (Socket socket = new Socket(serverIP, serverPort);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("Connected to the server. Type 'exit' to quit.");

                Thread receiverThread = new Thread(() -> {
                    try {
                        String serverMessage;
                        while ((serverMessage = reader.readLine()) != null) {
                            System.out.println("Server: " + serverMessage);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                receiverThread.start();

                String userInput;
                while ((userInput = consoleReader.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(userInput)) {
                        break;
                    }
                    writer.println(userInput);
                }

                receiverThread.interrupt();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
