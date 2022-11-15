package assignment_1;

import java.io.IOException;
import java.net.*;

public class Server implements Runnable {

    String message = "Hello. I am the server.";
    int intervall = 2000;

    public Server() {

    }
    public void run(){
                System.out.println("Server running");

        while (!Thread.interrupted()){
            try {
                Thread.sleep(intervall);
                InetAddress ip = InetAddress.getLocalHost();
                int toPort = 12345;
                DatagramSocket ds = new DatagramSocket();

                byte[] bytes = message.getBytes();
                DatagramPacket dgp = new DatagramPacket(bytes, bytes.length,ip,toPort);
                ds.send(dgp);
                System.out.println("package sent from " + ip);


            } catch (InterruptedException e) {
                System.out.println("Server Interrupted");
                break;
            } catch (IOException e) {
                System.out.println("IO Exception");
                e.printStackTrace();
            }
        }
    }
}
