package Examination;

public abstract class Plant implements Poison {

    protected final String name;
    final private double height;  //INKAPSLING

    public Plant(String name, double height) {
        this.name = name;
        this.height = height;
    }

    protected double getHeight() {
        return this.height;
    }

    public String getName() {
        return name;
    }

    abstract void WateringPlan();

}


