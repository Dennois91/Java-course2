package assignment_1.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{

    public Server() {
    }
    @Override
    public void run() {
        System.out.println("Servers started");
        try (ServerSocket s = new ServerSocket(55555);
             Socket socket = s.accept();
             BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String temp;
            while ((temp = buf.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
