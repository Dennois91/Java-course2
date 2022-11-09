package kladdpapper;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramReceiver implements Runnable{
        int port = 12345;
        DatagramSocket ds = new DatagramSocket(port);
        byte[] bytes = new byte[254];

    public DatagramReceiver() throws IOException {

    }

    @Override
    public void run() {

        while (true) {
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
            try {
                ds.receive(dgp);
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
