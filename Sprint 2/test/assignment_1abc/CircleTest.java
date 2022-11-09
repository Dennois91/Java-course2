package assignment_1abc;

import org.junit.jupiter.api.Test;

public class CircleTest {

    Circle circle = new Circle(10);

    @Test
    void getArea() {
        assert circle.getArea() == Math.round(circle.pi * Math.pow(circle.radie, 2));
        assert circle.getArea() == 314;
        assert circle.getArea() != 314.16;
    }

    @Test
    void getCircumference() {
        //O = 2 ⋅ π ⋅ r
        assert circle.getCircumference() == Math.round(2 * circle.pi * circle.radie);
        assert circle.getCircumference() != 62.8;
    }
}
