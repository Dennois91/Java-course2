package assignment_8_extends_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    Protokoll logic = new Protokoll();

    public Server() {
        System.out.println("server running");

        try (ServerSocket ss = new ServerSocket(55556);
             Socket s = ss.accept();
             ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))
        ) {

            out.writeObject(logic.getOutput(null));

            String request;
            while ((request = in.readLine()) != null) {
                out.writeObject(logic.getOutput(request));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("server didnt start");
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
