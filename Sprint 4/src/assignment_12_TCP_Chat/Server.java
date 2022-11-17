package assignment_12_TCP_Chat;

import java.io.*;
import java.net.Socket;

public class Server extends Thread {

    Socket s;
    MultiCaster multiCaster;

    int onlineUsers = 0;


    public Server(Socket s, MultiCaster multiCaster) {
        this.s = s;
        this.multiCaster = multiCaster;
    }

    public void run() {

        try (PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))
        ) {
            multiCaster.addWriter(out);
            while (true) {
                String input = in.readLine();
                if (input == null) {
                    multiCaster.removeWriter(out);
                    s.close();
                    return;
                }
                for (PrintWriter writer : multiCaster.getWriters()) {
                    writer.println(input);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
