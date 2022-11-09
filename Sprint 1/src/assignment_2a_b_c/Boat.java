package assignment_2a_b_c;

import java.util.Scanner;

public class Boat extends Vehicle implements Printable {
    private final int deadweight;


    public Boat(int speed, int weight, int deadweight) {
        super(speed, weight);
        this.deadweight = deadweight;
    }

    public void Turn() {
        System.out.println("How many degrees would you like to turn the boat?");
        int turn;

        Scanner scan = new Scanner(System.in);
        turn = scan.nextInt();
        if (turn <= 360 && turn >= -360) {
            System.out.println("you turned the boat " + turn + " degrees");
        } else {
            System.out.println("you did not type a valid input.");
        }
    }


    @Override
    public String toString() {
        return "Boat can be loaded to " + deadweight + " Speed = " + getSpeed() + " Weight = " + getWeight();
    }

    @Override
    public void PrintMe() {
        System.out.println("Boat: Boat can be loaded to " + deadweight + " Speed = " + getSpeed() + " Weight = " + getWeight());
    }
}
