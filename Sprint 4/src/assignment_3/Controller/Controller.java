package assignment_3.Controller;

import assignment_3.Model.DatagramReceiver;
import assignment_3.Model.DatagramSender;
import assignment_3.View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.*;

public class Controller {
    View view;
    JTextArea area;
    String ip = "234.235.236.237";
    InetAddress iadr = InetAddress.getByName(ip);
    int toPort = 12540;
    MulticastSocket mCSocket;
    String username;

    public Controller(View view, String username) throws IOException {
        this.view = view;
        this.username = username;
        area = view.chatArea;
    }

    public void InitController() throws IOException {
        view.inputField.addActionListener(this::input);
        view.button.addActionListener(this::button);
        setUpNet();
        send(username + " logged in:");
        DatagramReceiver receiver = new DatagramReceiver(mCSocket, area);
        Thread t1 = new Thread(receiver);
        t1.start();
    }

    protected void setUpNet() throws IOException {
        InetSocketAddress group = new InetSocketAddress(iadr, toPort);
        NetworkInterface netIf = NetworkInterface.getByName("eth0");
        mCSocket = new MulticastSocket(toPort);
        mCSocket.joinGroup(group, netIf);
    }

    private void button(ActionEvent event) {
        send(username + " Logged out");
        System.exit(0);

    }

    private void input(ActionEvent event) {
        if (!event.getActionCommand().isEmpty()) {
            new DatagramSender(event.getActionCommand(), mCSocket, iadr, toPort);
            view.inputField.setText("");
        }
    }

    private void send(String text) {
        new DatagramSender((text + "\n"), mCSocket, iadr, toPort);

    }
}
