package assignment_2a_b_c;

import java.util.Scanner;

public class Car extends Vehicle implements Printable, GotWheels {
    private final int gears;
    private int currentGear;
    private final int wheels = 4;

    public Car(int speed, int weight, int gears, int currentGear) {
        super(speed, weight);
        this.gears = gears;
        this.currentGear = currentGear;
    }

    public void ShiftGear() {
        int shift;
        System.out.println("Shift up or down? type 1 or -1");
        Scanner scan = new Scanner(System.in);
        shift = scan.nextInt();
        if (shift == 1 && currentGear <= gears - 1 || currentGear >= 2 && shift == -1) {
            currentGear = currentGear + shift;
            setSpeed(currentGear * 20);
        } else {
            System.out.println("you did not type a valid input.");
        }

    }


    @Override
    public String toString() {
        return "Number of gears = " + gears + " Current gear = " + currentGear +
                " Speed = " + getSpeed() + " Weight = " + getWeight();

    }

    @Override
    public void PrintMe() {
        System.out.println("Car: Number of gears = " + gears + " Current gear = " + currentGear +
                " Speed = " + getSpeed() + " Weight = " + getWeight());
    }

    @Override
    public void getNrOfWheels() {
        System.out.println("Got " + wheels + " wheels");
    }
}

