package assignment_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListen extends MouseAdapter {

    JButton button;

    public MouseListen(JButton button) {
        this.button = button;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setBackground(Color.RED);
        button.setForeground(Color.GREEN);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.setBackground(null);
        button.setForeground(null);
    }
}
