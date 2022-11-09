package assignment_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PictureHandler extends JFrame implements ActionListener {

    String picture1 = "src/assignment_1/picture/Baby.JPG";
    String picture2 = "src/assignment_1/picture/Sommar.JPG";
    ImageIcon imageIcon = new ImageIcon(picture1);
    ImageIcon imageIcon2 = new ImageIcon(picture2);
    JLabel imageViewer;
    JButton button1 = new JButton("NEXT");
    int toggler = 0;
    public PictureHandler() {
        JFrame f = new JFrame("PICTURES");
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        f.add(p);
        p.add(button1, BorderLayout.SOUTH);
        button1.addActionListener(this);

        imageViewer = new JLabel(imageIcon);
        imageViewer.setPreferredSize(new Dimension(1500,950));

        p.add(imageViewer, BorderLayout.CENTER);

        f.pack();
        f.setLocation(400, 0);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(toggler == 0){
            imageViewer.setIcon(imageIcon2);
            toggler = 1;
        }
        else if(toggler == 1){
            imageViewer.setIcon(imageIcon);
            toggler = 0;
        }
    }
}
