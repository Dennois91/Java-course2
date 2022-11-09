package Minilabb_lektion1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo extends JFrame implements ActionListener {

    JLabel label = new JLabel("Hej");
    JButton button = new JButton("Tryck Här");


    public ButtonDemo() {
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        button.addActionListener(this);
        this.add(p1);
        p1.add(label);
        p1.add(button);

        this.pack();
        this.setLocation(1000,500);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (label.getText().equalsIgnoreCase("Hej")){
            label.setText("Hopp");
        }
        else {
            label.setText("Hej");
        }

    }
}
