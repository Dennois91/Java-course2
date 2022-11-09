package assignment_3;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class Controller {
    View view;
    JTextArea area;


    public Controller(View view) {
        this.view = view;
        area = view.chatArea;

    }

    public void InitController() throws IOException {
        view.inputField.addActionListener(this::input);
        view.button.addActionListener(this::button);
        Thread t1 = new Thread(new DatagramReceiver());
        t1.start();

    }

    private void button(ActionEvent event) {
    }

    private void input(ActionEvent event) {
        if (!event.getActionCommand().isEmpty()) {
            area.append(event.getActionCommand());
            new DatagramSender(event.getActionCommand());

        }
    }
}
