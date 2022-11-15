package assignment_4;

import assignment_3.Model.DatagramSender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class Sender extends JFrame implements ActionListener{

    JPanel base = new JPanel(new GridLayout(3, 1));
    JLabel info = new JLabel("Enter city and temp");
    JTextField city = new JTextField();
    JTextField temp = new JTextField();
    InetAddress iadr = InetAddress.getByName("234.235.236.237");
    int toPort = 12540;
    MulticastSocket mCSocket;


    public Sender() throws UnknownHostException {
        add(base);
        base.add(info);
        base.add(city);
        base.add(temp);
        city.addActionListener(this);
        temp.addActionListener(this);
        city.setToolTipText("CITY");
        temp.setToolTipText("TEMPERATURE");
        try {
            setUpNet();
        }catch (IOException e){
            e.printStackTrace();
        }

        setSize(300,120);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    protected void setUpNet() throws IOException {
        InetSocketAddress group = new InetSocketAddress(iadr, toPort);
        NetworkInterface netIf = NetworkInterface.getByName("eth0");
        mCSocket = new MulticastSocket(toPort);
        mCSocket.joinGroup(group, netIf);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (city.getText().isEmpty() || temp.getText().isEmpty()){
            info.setText("Fill both fields");
        }else {
            new DatagramSender(city.getText() + " " + temp.getText()
                    ,mCSocket,iadr,toPort);
            info.setText(city.getText() + " " + temp.getText() + " Registered");
        }
    }


    public static void main(String[] args) throws UnknownHostException {
        new Sender();

    }
}
