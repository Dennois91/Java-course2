package assignment_3;

import java.io.IOException;
import java.net.*;

public class DatagramReceiver implements Runnable {
    String ip = "234.235.236.237";
    InetAddress iadr = InetAddress.getByName(ip);
    int toPort = 12540;
    InetSocketAddress group = new InetSocketAddress(iadr, toPort);
    NetworkInterface netIf = NetworkInterface.getByName("wlan4");
    MulticastSocket socket = new MulticastSocket(toPort);
    byte[] bytes = new byte[254];


    public DatagramReceiver() throws IOException {

    }


    @Override
    public void run() {
        try {
            socket.joinGroup(group, netIf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
            try {
                socket.receive(dgp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(dgp.getPort());
            System.out.println(dgp.getAddress());
            String s = new String(dgp.getData(), 0, dgp.getLength());
            System.out.println(s);

        }
    }
}
