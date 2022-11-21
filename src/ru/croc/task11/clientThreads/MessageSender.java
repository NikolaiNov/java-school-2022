package ru.croc.task11.clientThreads;

import ru.croc.task11.Client;

import java.io.*;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class MessageSender implements Runnable {
    BufferedReader in;

    public MessageSender() {
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        String message;
        LocalTime time;
        try {
            while ((message = in.readLine()) != null) {
                Client.out.write(message + '\n');
                Client.out.flush();
                time = LocalTime.now(ZoneId.of(Client.timezone)).truncatedTo(ChronoUnit.SECONDS);
                System.out.println(time + " [CLIENT] This message has sent to this chat");
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
