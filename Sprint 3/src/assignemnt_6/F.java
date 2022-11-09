package assignemnt_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class F extends JFrame {

    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JTextField input = new JTextField("First");

    public F() {
        setLayout(new GridLayout(3, 1));
        add(b1);
        add(b2);
        add(input);

        addWindowListener(windowListen);
        input.addFocusListener(focusListen);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    WindowAdapter windowListen = new WindowAdapter() {
        @Override
        public void windowActivated(WindowEvent e) {
            input.requestFocus();
        }
    };
    FocusListener focusListen = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (e.getComponent() == input) {
                input.setBackground(Color.GREEN);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (e.getComponent() == input) {
                input.setBackground(Color.MAGENTA);
            }
        }
    };
}
