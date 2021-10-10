package quarter01.level02.lesson06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static final String ADDRESS = "localhost";
    public static final int PORT = 8189;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started");

            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

            // Отдельный поток - на отправку сообщений
            Scanner scanner = new Scanner(System.in);
            Thread inputThread = new Thread(() -> {
                try {
                    while (true) {
                        outputStream.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            inputThread.setDaemon(true);
            inputThread.start();

            // Основной поток - на получение сообщений
            while (true) {
                String inputMessage = inputStream.readUTF();

                if (inputMessage.equalsIgnoreCase("/close")) {
                    System.out.println("Client disconnected");
                    outputStream.writeUTF(inputMessage);
                    break;
                } else {
                    System.out.println("Client: " + inputMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
