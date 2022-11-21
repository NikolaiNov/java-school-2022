package ru.croc.task11.serverThreads;

import ru.croc.task11.Server;

import java.io.*;
import java.net.Socket;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Connection implements Runnable {
    Socket socket;
    BufferedReader in;
    BufferedWriter out;
    String nickname;
    String timezone;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.nickname = in.readLine();
        this.timezone = in.readLine();
        System.out.println("[Connect] Nickname: " + this.nickname + " | Timezone: " + this.timezone);
        sendToAll("SERVER", nickname + " has entered this chat");
    }

    public void run() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                System.out.println("[Message] Nickname: " + this.nickname + " | Message: " + message);
                sendToAll(this.nickname, message);
            }
        } catch (IOException e) {
            try {
                socket.close();
                synchronized (Server.connections) {
                    Server.connections.remove(this);
                }
                System.out.println("[Disconnect] Nickname: " + this.nickname);
                sendToAll("SERVER", nickname + " has left this chat");
            } catch (IOException eSocketClose) {
                System.out.println("[!] Failed to close socket");
            }
        }
    }

    public void sendToAll(String fromNickname, String message) {
        LocalTime time;
        try {
            synchronized (Server.connections) {
                for (Connection connection : Server.connections) {
                    if (connection.hashCode() == this.hashCode()) {
                        continue;
                    }
                    time = LocalTime.now(ZoneId.of(connection.timezone)).truncatedTo(ChronoUnit.SECONDS);
                    connection.out.write(time + " [" + fromNickname + "] " + message + '\n');
                    connection.out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
