package assignment_14;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Gui extends JFrame {

    JPanel base = new JPanel(new BorderLayout());
    JLabel message = new JLabel();

    public Gui() throws HeadlessException {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("Sprint 4/src/assignment_14/settings.properties"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        add(base);
        base.add(message,BorderLayout.NORTH);

        String italic = "fontItalic";
        String bold = "fontBold";

        message.setFont(new Font(p.getProperty("fontType"),
                Integer.parseInt(p.getProperty(italic)),
                Integer.parseInt(p.getProperty("fontSize"))));
        message.setText(p.getProperty("name"));

        setSize(Integer.parseInt(p.getProperty("width")),Integer.parseInt(p.getProperty("height")));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


}
