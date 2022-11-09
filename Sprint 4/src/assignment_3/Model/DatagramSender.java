package assignment_3.Model;

import java.io.IOException;
import java.net.*;

public class DatagramSender {

    public DatagramSender(String mess, MulticastSocket socket,
                          InetAddress iadr, int toPort) {
        try {
            byte[] bytes = mess.getBytes();
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, iadr, toPort);
            socket.send(dgp);
        } catch (IOException e) {
            System.out.println("Exception in Datagram Sender");
            e.printStackTrace();
        }
    }
}
