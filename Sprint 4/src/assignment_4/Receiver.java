package assignment_4;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.*;

public class Receiver extends JFrame {
    JTextArea register = new JTextArea();
    MulticastSocket mCSocket;


    public Receiver() throws HeadlessException, IOException {


        add(register);
        setLocation(200, 300);
        setSize(150, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUpNet();
        while (true) {
            byte[] bytes = new byte[254];
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
            try {
                mCSocket.receive(dgp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String s = new String(bytes, 0, bytes.length);
            register.append(s + "\n");
        }
    }

    protected void setUpNet() throws IOException {
        InetAddress iadr = InetAddress.getByName("234.235.236.237");
        int toPort = 12540;
        InetSocketAddress group = new InetSocketAddress(iadr, toPort);
        NetworkInterface netIf = NetworkInterface.getByName("eth0");
        mCSocket = new MulticastSocket(toPort);
        mCSocket.joinGroup(group, netIf);
    }

    public static void main(String[] args) throws IOException {
        new Receiver();
    }
}
