package assignment_1abc;

import org.junit.jupiter.api.Test;

public class TriangleTest {

    Triangle triangle = new Triangle(10, 10);

    @Test
    void getArea() {
        assert triangle.getArea() == 50;
        assert triangle.getArea() != 5;
        assert triangle.getArea() != 500;
        assert triangle.getArea() != .50;
        assert triangle.getArea() != -50;
        assert triangle.getArea() == triangle.length * triangle.width / 2;
    }

    @Test
    void getCircumference() {
        assert triangle.getCircumference() == triangle.length + triangle.length + triangle.width;
        assert triangle.getCircumference() == 30;
        assert triangle.getCircumference() != -30;
        assert triangle.getCircumference() != 31;

    }
}
