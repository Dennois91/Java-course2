package assignment_2;

import javax.swing.*;

public class MainProgram {
    public MainProgram() {

        Car car = new Car();

        double temp;
        temp = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter current mileage count"));
        car.mileage = temp;

        temp = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter mileage count from one year ago"));
        car.mileageOneYearAgo = temp;

        temp = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter total amount of gas used this year"));
        car.yearlyGasTotal = temp;

        System.out.println(car.milesDrivenString());
        System.out.println(car.litersOfGasString());
        System.out.println(car.literPer10KmString());
    }

    public static void main(String[] args) {
        MainProgram mainProgram = new MainProgram();

    }
}