package assignment_7;

import javax.swing.*;

public class Gui extends JFrame {
    JButton b1 = new JButton("Color me");

    public Gui() {
        add(b1);
        b1.addMouseListener(new MouseListen(b1));

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
