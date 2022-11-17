package assignment_12_TCP_Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends JFrame implements ActionListener {

    JPanel base = new JPanel(new BorderLayout());
    JTextArea chattWindow = new JTextArea();
    JTextField inputField = new JTextField();
    String userInput;
    PrintWriter out;
    String name;


    public Client() {
        this.name = JOptionPane.showInputDialog(null,"Enter alias");

        add(base);
        base.add(chattWindow, BorderLayout.CENTER);
        base.add(inputField, BorderLayout.SOUTH);


        inputField.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        try {Socket s = new Socket("127.0.0.1", 44444);
             out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            out.println(name + " connected to server");

            String fromServer;

            while ((fromServer = in.readLine()) != null) {
                chattWindow.append(fromServer + "\n");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        new Client();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userInput = e.getActionCommand();
        out.println(name + ": "+userInput);
        inputField.setText("");
    }
}
