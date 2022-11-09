package Minilabb_lektion1;

import javax.swing.*;
import java.awt.*;


public class JFrameDemo extends JFrame {
        JLabel jLabel = new JLabel("HALLÅ");
        JButton button = new JButton("Tryck här");


    public JFrameDemo() throws HeadlessException {
        JFrame frame = new JFrame();
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3,2));
        frame.add(p);
       // this.add(p);
        p.add(jLabel);
        p.add(button);

        p.setOpaque(true);
        p.setBackground(Color.MAGENTA);

        jLabel.setOpaque(true);
        jLabel.setBackground(Color.CYAN);

        button.setOpaque(true);
        button.setBackground(Color.GREEN);

        pack();
        setLocation(500,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
