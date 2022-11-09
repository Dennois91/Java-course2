package Examination;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeatEatingTest {
    MeatEating meatloaf = new MeatEating("Meatloaf", 0.7);
    //Baseline 0.1
    //extraProtein = height * 0.2 + 0.1

    @Test
    void wateringPlan() {
        assert meatloaf.getExtraProtein() == 0.24;
        assert meatloaf.getExtraProtein() != 0.23;
        assert meatloaf.getExtraProtein() != 24;
        assert meatloaf.getExtraProtein() != -0.24;
    }
}