package assignment_1abc;

import org.junit.jupiter.api.Test;

class SquareTest {

    Square square = new Square(10, 10);


    @Test
    void getArea() {
        assert square.getArea() == 100;
        assert square.getArea() != 10.0;

    }

    @Test
    void getCircumference() {
        assert square.getCircumference() == square.width * 4;
        assert square.getCircumference() == square.length * 4;
        assert square.getCircumference() == 40;
        assert square.getCircumference() != 4.0;
        assert square.getCircumference() != -40;
    }
}