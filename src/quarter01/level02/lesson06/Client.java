package quarter01.level02.lesson06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket(Server.ADDRESS, Server.PORT);
            System.out.println("Connected to the server");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

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
                    System.out.println("Server dropped connection");
                    outputStream.writeUTF(inputMessage);
                    break;
                } else {
                    System.out.println("Server: " + inputMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
