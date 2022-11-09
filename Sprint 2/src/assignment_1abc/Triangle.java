package assignment_1abc;

public class Triangle implements Figure {
    int length; //height
    int width; //Base

    public Triangle(int length, int width) {
        if (length == width) {
            this.length = length;
            this.width = width;
        } else {
            System.out.println("All sides of the triangle must be equal");
        }
    }

    @Override
    public int getArea() {
        return length * width / 2;
    }

    @Override
    public int getCircumference() {
        return length + length + width;
    }
}
