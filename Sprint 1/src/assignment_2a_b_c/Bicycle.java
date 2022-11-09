package assignment_2a_b_c;

public class Bicycle extends Vehicle implements Printable, GotWheels {
    private final int gears;
    private int currentGear;
    private final int wheels = 2;


    public Bicycle(int speed, int weight, int gears, int currentGear) {
        super(speed, weight);
        this.gears = gears;
        this.currentGear = currentGear;
    }

    public void ShiftUp() {
        if (currentGear < gears) {
            currentGear++;
            setSpeed(currentGear * 2);
            System.out.println("You shifted up. Current gear is " + currentGear);
        } else {
            System.out.println("Cant shift higher");
        }
    }

    public void ShiftDown() {
        if (currentGear > 1) {
            currentGear--;
            setSpeed(currentGear * 2);
            System.out.println("You shifted down. Current gear is " + currentGear);
        } else {
            System.out.println("Cant shift lower");
        }
    }


    @Override
    public String toString() {
        return "Number of gears = " + gears + " Current gear = " + currentGear + " " + super.toString();
    }

    @Override
    public void PrintMe() {
        System.out.println("Bicycle: Number of gears = " + gears + " Current gear = " + currentGear + " " + super.toString());
    }

    @Override
    public void getNrOfWheels() {
        System.out.println("Got " + wheels + " wheels");
    }
}

