package kladdpapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSender {


    public DatagramSender() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InetAddress ip = InetAddress.getLocalHost();
        int toPort = 12345;
        DatagramSocket ds = new DatagramSocket();
        String mess;

        while ((mess = in.readLine()) != null){
            byte[] bytes = mess.getBytes();
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length,ip,toPort);
            ds.send(dgp);

        }
    }

    public static void main(String[] args) throws IOException {
        DatagramSender ds = new DatagramSender();
    }
}
