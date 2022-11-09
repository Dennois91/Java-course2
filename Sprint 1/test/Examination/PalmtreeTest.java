package Examination;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalmtreeTest {

    Palmtree laura = new Palmtree("Laura",5);
    // Height * 0.5 = Amount of water per day

    @Test
    void wateringPlan() {
        assert laura.getAmountOfFluid() ==  2.5;
        assert laura.getAmountOfFluid() != 2.4;
        assert laura.getAmountOfFluid() != 25;
        assert laura.getAmountOfFluid() != 0.25;
    }
}