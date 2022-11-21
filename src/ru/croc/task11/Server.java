package ru.croc.task11;

import ru.croc.task11.serverThreads.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
    public final static List<Connection> connections = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Set port of the server as a command line argument");
        } else {
            Thread thread;
            Connection connection;
            Socket socket;

            int port = Integer.parseInt(args[0]);
            if (port < 1 || port > 65535) {
                System.out.println("[!] Incorrect port. Setting default port 25565");
                port = 25565;
            }

            try {
                try (ServerSocket serverSocket = new ServerSocket(port)) {
                    System.out.println("Server started at port " + port);
                    System.out.println("Waiting for connections...");
                    while ((socket = serverSocket.accept()) != null) {
                        connection = new Connection(socket);
                        connections.add(connection);
                        thread = new Thread(connection);
                        thread.start();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
