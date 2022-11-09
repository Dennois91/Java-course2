package assignment_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GasGui implements ActionListener {

    JFrame f = new JFrame();
    JPanel mainGrid = new JPanel();
    JPanel forInput = new JPanel();
    JPanel forInputLabels = new JPanel();
    JPanel forOutput = new JPanel();

    JTextField textField1 = new JTextField(10);
    JTextField textField2 = new JTextField(10);
    JTextField textField3 = new JTextField(10);

    JLabel output1 = new JLabel("0");
    JLabel output2 = new JLabel("0");
    JLabel output3 = new JLabel("0");

    public GasGui() {

        forInputLabels.add(new JLabel("Set mileage counter: "));
        forInputLabels.add(new JLabel("Set mileage counter one year ago: "));
        forInputLabels.add(new JLabel("Set liters of gas used: "));

        mainGrid.setLayout(new BorderLayout());
        forInput.setLayout(new GridLayout(3, 1));
        forInputLabels.setLayout(new GridLayout(3, 1));
        forOutput.setLayout(new GridLayout(1, 3));

        f.add(mainGrid);
        mainGrid.add(forInput, BorderLayout.CENTER);
        mainGrid.add(forInputLabels, BorderLayout.LINE_START);
        mainGrid.add(forOutput, BorderLayout.SOUTH);

        forInput.add(textField1);
        forInput.add(textField2);
        forInput.add(textField3);

        forOutput.add(new JLabel("Amount of kilometers driven: "));
        forOutput.add(output1);
        forOutput.add(new JLabel("Liters of gas used: "));
        forOutput.add(output2);
        forOutput.add(new JLabel("Spent per 10km (Mil): "));
        forOutput.add(output3);

        textField1.addActionListener(this);
        textField2.addActionListener(this);
        textField3.addActionListener(this);

        f.pack();
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == textField1 || e.getSource() == textField2
                || e.getSource() == textField3) {
            Scanner scField1 = new Scanner(textField1.getText());
            Scanner scField2 = new Scanner(textField2.getText());
            Scanner scField3 = new Scanner(textField3.getText());
            if (scField1.hasNextDouble() && scField2.hasNextDouble()
                    && scField2.hasNextDouble()) {
                double meterNow = scField1.nextDouble();
                double meterOneYearAgo = scField2.nextDouble();
                double totalGasSpent = scField3.nextDouble();
                output1.setText(String.format("%8.0f", milesDriven(meterNow, meterOneYearAgo)));
                output2.setText(String.format("%7.1f", totalGasSpent));
                output3.setText(String.format("%1.2f", averageConsumedGas(totalGasSpent
                        , milesDriven(meterNow, meterOneYearAgo))));
            }
        }
    }
    protected static double milesDriven(double meterNow, double meterOneYearAgo) {
        return meterNow - meterOneYearAgo;
    }

    protected static double averageConsumedGas(double totalGasSpent, double milesDriven) {
        return (totalGasSpent / milesDriven) * 10;
    }

}
