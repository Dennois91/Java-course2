package assignment_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cashier extends JFrame implements ActionListener {

    JPanel north = new JPanel();
    JPanel center = new JPanel();
    JPanel south = new JPanel();

    JLabel priceLabel = new JLabel("Cost of item:  ");
    JLabel payingLabel = new JLabel("Payed amount:  ");
    JLabel totalResult = new JLabel();
    JLabel result1000 = new JLabel();
    JLabel result500 = new JLabel();
    JLabel result200 = new JLabel();
    JLabel result100 = new JLabel();
    JLabel result50 = new JLabel();
    JLabel result20 = new JLabel();
    JLabel result10 = new JLabel();
    JLabel result5 = new JLabel();
    JLabel result2 = new JLabel();
    JLabel result1 = new JLabel();

    JTextField priceInput = new JTextField();
    JTextField payedInput = new JTextField();

    JCheckBox checkBox1000 = new JCheckBox("1000");
    JCheckBox checkBox500 = new JCheckBox("500");
    JCheckBox checkBox200 = new JCheckBox("200");
    JCheckBox checkBox100 = new JCheckBox("100");
    JCheckBox checkBox50 = new JCheckBox("50");
    JCheckBox checkBox20 = new JCheckBox("20");
    JCheckBox checkBox10 = new JCheckBox("10");
    JCheckBox checkBox5 = new JCheckBox("5");
    JCheckBox checkBox2 = new JCheckBox("2");
    JCheckBox checkBox1 = new JCheckBox("1");

    public Cashier() {
        setLayout(new BorderLayout());
        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
        south.setBackground(Color.GREEN);

        north.setLayout(new GridLayout(2, 2));
        north.add(payingLabel);
        north.add(payedInput);
        north.add(priceLabel);
        north.add(priceInput);

        center.setLayout(new GridLayout(5, 2));
        center.add(checkBox1000);
        center.add(checkBox500);
        center.add(checkBox200);
        center.add(checkBox100);
        center.add(checkBox50);
        center.add(checkBox20);
        center.add(checkBox10);
        center.add(checkBox5);
        center.add(checkBox2);
        center.add(checkBox1);

        south.add(totalResult);
        south.add(result1000);
        south.add(result500);
        south.add(result200);
        south.add(result100);
        south.add(result50);
        south.add(result20);
        south.add(result10);
        south.add(result5);
        south.add(result2);
        south.add(result1);

        payedInput.addActionListener(this);
        priceInput.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payedInput || e.getSource() == priceInput) {
            int payed = Integer.parseInt(payedInput.getText());
            int price = Integer.parseInt(priceInput.getText());
            int refunded = payed - price;
            totalResult.setText("Total money back: " + refunded + "$   ");
            if (checkBox1000.isSelected()) {
                result1000.setText(refunded / 1000 + " of $1000  ");
                refunded = refunded % 1000;
                pack();
            }
            if (checkBox500.isSelected()) {
                result500.setText(refunded / 500 + " of $500  ");
                refunded = refunded % 500;
                pack();
            }
            if (checkBox200.isSelected()) {
                result200.setText(refunded / 200 + " of $200  ");
                refunded = refunded % 200;
                pack();
            }
            if (checkBox100.isSelected()) {
                result100.setText(refunded / 100 + " of $100  ");
                refunded = refunded % 100;
                pack();
            }
            if (checkBox50.isSelected()) {
                result50.setText(refunded / 50 + " of $50  ");
                refunded = refunded % 50;
                pack();
            }
            if (checkBox20.isSelected()) {
                result20.setText(refunded / 20 + " of $20  ");
                refunded = refunded % 20;
                pack();
            }
            if (checkBox10.isSelected()) {
                result10.setText(refunded / 10 + " of $10  ");
                refunded = refunded % 10;
                pack();
            }
            if (checkBox5.isSelected()) {
                result5.setText(refunded / 5 + " of $5  ");
                refunded = refunded % 5;
                pack();
            }
            if (checkBox2.isSelected()) {
                result2.setText(refunded / 2 + " of $2  ");
                refunded = refunded % 2;
                pack();
            }
            if (checkBox1.isSelected()) {
                result1.setText(refunded + " of $1  ");
                pack();
            }
        }
    }
}
