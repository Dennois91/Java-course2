package Examination;

import org.junit.jupiter.api.Test;
class CactusTest {
    Cactus cactus = new Cactus("Igge",0.20);
    //2 cl of water per day



    @Test
    void wateringPlan() {
        assert cactus.amountOfFluid == 2;
        assert cactus.amountOfFluid != 1;
        assert cactus.amountOfFluid != 3;
        assert cactus.amountOfFluid != -2;
        assert  cactus.amountOfFluid != 0.2;
    }
}