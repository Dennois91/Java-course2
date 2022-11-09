package assignment_3;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame{

    JPanel base = new JPanel(new BorderLayout());
    JButton button = new JButton("Disconnect");
    JTextArea chatArea= new JTextArea();
    JTextField inputField = new JTextField();

    public View() {
        add(base);
        base.add(button,BorderLayout.NORTH);
        base.add(chatArea,BorderLayout.CENTER);
        base.add(inputField,BorderLayout.SOUTH);

        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
