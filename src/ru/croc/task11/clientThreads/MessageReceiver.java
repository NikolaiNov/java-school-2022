package ru.croc.task11.clientThreads;

import ru.croc.task11.Client;

import java.io.*;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class MessageReceiver implements Runnable {
    public void run() {
        String message;
        LocalTime time;
        try {
            while ((message = Client.in.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            time = LocalTime.now(ZoneId.of(Client.timezone)).truncatedTo(ChronoUnit.SECONDS);
            System.out.println(time + " [CLIENT] Lost connection to the server");
            try {
                Client.socket.close();
            } catch (IOException eSocketClose) {
                time = LocalTime.now(ZoneId.of(Client.timezone)).truncatedTo(ChronoUnit.SECONDS);
                System.out.println(time + " [CLIENT] [!] Failed to close the socket");
            }
        }
    }
}
