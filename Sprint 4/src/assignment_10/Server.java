package assignment_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    Protokoll logic = new Protokoll();
    Socket s;

    public Server(Socket s) {
        this.s = s;
    }

    public void run() {
        System.out.println("server running");

        try (
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
}
