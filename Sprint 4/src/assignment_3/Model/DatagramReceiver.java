package assignment_3.Model;

import javax.swing.*;
import java.io.IOException;
import java.net.*;

public class DatagramReceiver implements Runnable {

    byte[] bytes = new byte[254];
    MulticastSocket mSC;
    JTextArea chat;


    public DatagramReceiver(MulticastSocket mSC, JTextArea chat) {
        this.mSC = mSC;
        this.chat = chat;
    }

    @Override
    public void run() {

        while (true) {
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
            try {
                mSC.receive(dgp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String s = new String(dgp.getData(), 0, dgp.getLength());
            chat.append(s+"\n");
        }
    }
}
