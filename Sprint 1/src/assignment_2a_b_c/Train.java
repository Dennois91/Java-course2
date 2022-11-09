package assignment_2a_b_c;

public class Train extends Vehicle implements Printable {
    private int carriage;

    public Train(int speed, int weight, int carriage) {
        super(speed, weight);
        this.carriage = carriage;
    }

    public void AddCarriage() {
        System.out.println("Adding another carriage.");
        carriage++;
    }

    public void CountCarriages() {
        System.out.println(carriage + " Carriages is connected to the train.");
    }


    @Override
    public String toString() {
        return carriage + " Carriages is connected " + " Speed = " + getSpeed() + " Weight = " + getWeight();
    }

    @Override
    public void PrintMe() {
        System.out.println("Train: " + carriage + " Carriages is connected " + " Speed = " + getSpeed() + " Weight = " + getWeight());
    }
}
