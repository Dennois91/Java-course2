package assignment_3;

import java.io.IOException;
import java.net.*;

public class DatagramSender {


    public DatagramSender(String mess) {
        try {
            String ip = "234.235.236.237";
            InetAddress iadr = InetAddress.getByName(ip);
            int toPort = 12540;
            InetSocketAddress group = new InetSocketAddress(iadr, toPort);
            NetworkInterface netIf = NetworkInterface.getByName("wlan4");

            MulticastSocket socket = new MulticastSocket(toPort);
            socket.joinGroup(group, netIf);

            byte[] bytes = mess.getBytes();
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, iadr, toPort);
            socket.send(dgp);
        }catch (IOException e){
            System.out.println("Exception in Datagram Sender");
            e.printStackTrace();
        }
    }
}
