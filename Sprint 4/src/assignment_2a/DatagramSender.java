package assignment_2a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ThreadLocalRandom;

public class DatagramSender implements Runnable {

    InetAddress ip = InetAddress.getLocalHost();
    int toPort = 12345;
    DatagramSocket ds = new DatagramSocket();

    public DatagramSender() throws IOException {

    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String mess = quotes();
            byte[] bytes = mess.getBytes();
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, ip, toPort);
            try {
                ds.send(dgp);
            } catch (IOException e) {
                System.out.println("IO Exception");
                throw new RuntimeException(e);
            }
        }
    }

    public int randoms() {
        return ThreadLocalRandom.current().nextInt(1, 6);
    }

    public String quotes() {
        String[] quotes = (new String[]{"Quote 1", "Quote 2", "Quote 3", "Quote 4", "Quote 5",});
        return quotes[randoms()-1];
    }
}
