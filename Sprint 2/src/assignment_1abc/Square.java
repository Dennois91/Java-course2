package assignment_1abc;

public class Square implements Figure {
    int length;
    int width;

    public Square(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public int getArea() {
        return this.length * this.width;
    }

    @Override
    public int getCircumference() {
        return this.length * 4;
    }
}
