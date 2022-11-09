package assignment_2a_b_c;

public abstract class Vehicle implements Printable {
    private int speed;
    private final int weight;

    public Vehicle(int speed, int weight) {
        this.speed = speed;
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return "Speed = " + speed + " Weight = " + weight;
    }

    @Override
    public void PrintMe() {

    }
}

