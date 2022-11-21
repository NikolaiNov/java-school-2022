package ru.croc.task11;

import ru.croc.task11.clientThreads.MessageReceiver;
import ru.croc.task11.clientThreads.MessageSender;

import java.io.*;
import java.net.Socket;
import java.time.ZoneId;
import java.util.Scanner;

public class Client {
    public static BufferedReader in;
    public static BufferedWriter out;
    public static String nickname;
    public static String timezone;
    public static Socket socket;

    public static void main(String[] args) {
        String host;
        int port;

        Scanner scanner = new Scanner(System.in);
        System.out.println("----[First-time setup]-----");

        System.out.println("[CLIENT] Enter host:");
        host = scanner.nextLine();

        System.out.println("[CLIENT] Enter port:");
        try {
            port = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("[CLIENT] [!] Incorrect port. Setting default port 25565");
            port = 25565;
        }
        if (port < 1 || port > 65535) {
            System.out.println("[CLIENT] [!] Incorrect port. Setting default port 25565");
            port = 25565;
        }

        System.out.println("[CLIENT] Enter your nickname:");
        nickname = scanner.nextLine();
        
        System.out.println("[CLIENT] Enter your timezone (for example: 'Europe/Moscow'):");
        timezone = scanner.nextLine();
        if (!ZoneId.getAvailableZoneIds().contains(timezone)) {
            System.out.println("[CLIENT] [!] Incorrect timezone. Setting default timezone 'Europe/Moscow'");
            timezone = "Europe/Moscow";
        }

        try {
            socket = new Socket(host, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write(nickname + '\n');
            out.write(timezone + '\n');
            out.flush();

            System.out.println("[CLIENT] Successfully connected to " + host + ":" + port);
            System.out.println("-----[Chat]-----");

            Thread messageReceiverThread = new Thread(new MessageReceiver());
            Thread messageSenderThread = new Thread(new MessageSender());
            messageReceiverThread.start();
            messageSenderThread.start();
        } catch (IOException e) {
            System.out.println("[CLIENT] [!] Can't connect to " + host + ":" + port);
        }
    }
}
