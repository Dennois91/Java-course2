package assignment_4;

import java.util.Scanner;

public class MainProgram {
    public MainProgram() {

        Car car = new Car();
        Scanner scanner = new Scanner(System.in);

        double temp;
        System.out.println("Enter current mileage count");
        temp = scanner.nextDouble();
        car.mileage = temp;

        System.out.println("Enter mileage count from one year ago");
        temp = scanner.nextDouble();
        car.mileageOneYearAgo = temp;

        System.out.println("Enter total amount of gas used this year");
        temp = scanner.nextDouble();
        car.yearlyGasTotal = temp;

        System.out.println(car.milesDrivenString());
        System.out.println(car.litersOfGasString());
        System.out.println(car.literPer10KmString());
    }

    public static void main(String[] args) {
        MainProgram mainProgram = new MainProgram();

    }
}
/*
Uppgift 4 – Bensinförbrukning med Scanner
Kopiera uppgift 2 (inklusive tester). Du ska nu refaktorera ditt program så att du använder Scanner,
som läser från System.in, istället för JOptionPane.
Utskriften ska ske i kommandofönstret och ha formatet:
Antal körda mil: 1487
Antal liter bensin: 1235,4
Förbrukning per mil: 0,83
Använd dig av testerna för att kontrollera att du inte förstört något i programmet under
refaktoreringen.
*/