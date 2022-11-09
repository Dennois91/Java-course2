package assignment_1abc;

public class Circle implements Figure {

    int radie;
    final double pi = Math.PI;

    public Circle(int radie) {
        this.radie = radie;
    }

    @Override
    public int getArea() {
        return (int) Math.round(pi * Math.pow(radie, 2));
    }

    @Override
    public int getCircumference() {
        int round;
        round = (int) Math.round(2 * pi * radie);
        return round;
    }
}
