package assignment_4;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.io.*;

public class TextEditorGui extends JFrame {

    JPanel northBar = new JPanel();

    JLabel label = new JLabel("Filename: ");

    JTextField pathInputField = new JTextField();

    JButton bOpen = new JButton("Open");
    JButton bSave = new JButton("Save");
    JButton bPrint = new JButton("Print");
    JButton bExit = new JButton("Exit");

    JTextArea textInputArea = new JTextArea(500, 40);

    public TextEditorGui() {
        setLayout(new BorderLayout());
        JScrollPane pane = new JScrollPane(textInputArea);
        add(pane, BorderLayout.CENTER);


        add(northBar, BorderLayout.NORTH);
        northBar.setLayout(new GridLayout(1, 6));
        northBar.add(label);
        northBar.add(pathInputField);
        northBar.add(bOpen);

        bOpen.addActionListener(l -> {
            String filePath = pathInputField.getText();
            // Use src/assignment_4/text.txt
            try {
                FileReader fr = new FileReader(filePath);
                textInputArea.read(fr, null);

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Input/Output Error");
                e.printStackTrace();
            }
        });

        northBar.add(bSave);
        bSave.addActionListener(l -> {
            String filePath = pathInputField.getText();
            // Use src/assignment_4/output.txt
            try {
                BufferedWriter br = (new BufferedWriter(new FileWriter(filePath)));
                {
                    br.append(textInputArea.getText());
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Couldn't save file to " + filePath);
                e.printStackTrace();
            }
        });

        northBar.add(bPrint);
        bPrint.addActionListener(l -> {
            try {
                textInputArea.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        });

        northBar.add(bExit);
        bExit.addActionListener(l -> System.exit(0));

        setSize(650, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
