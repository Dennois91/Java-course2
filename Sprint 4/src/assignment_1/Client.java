package assignment_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Client implements Runnable {

    public Client() {
    }

    public void run() {
        System.out.println("Client is running");

        byte[] bytes = new byte[254];
        int port = 12345;
        DatagramSocket ds;
        DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
        try {
            ds = new DatagramSocket(port);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        while (!Thread.interrupted()) {
            try {
                ds.receive(dgp);

            } catch (IOException e) {
                System.out.println("Client Interrupted");
                e.printStackTrace();
                break;
            }

            String s = new String(dgp.getData(), 0, dgp.getLength());
            System.out.println(s + " From adress: " + dgp.getAddress());
        }
        System.out.println("Client interrupted");
    }
}