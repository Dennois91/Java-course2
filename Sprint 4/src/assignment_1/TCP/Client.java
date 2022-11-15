package assignment_1.TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Client extends Thread {

    public Client() {
    }

    @Override
    public void run() {
        System.out.println("Client started");
        try (Socket sock = new Socket("127.0.0.1", 55555);
             PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
        ) {
            String mess = "meddelande: ";

            while (!Thread.interrupted()) {
                out.println(mess);
                Thread.sleep(1000);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Interuppted");
            throw new RuntimeException(e);
        }
    }
}
