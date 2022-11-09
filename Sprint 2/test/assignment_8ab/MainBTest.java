package assignment_8ab;

import org.junit.jupiter.api.Test;

import java.util.List;

class MainBTest {

    MainB test = new MainB();

    @Test
    void readFIleToListTest(){
        List<Double> tempList = test.readFIleToList();
        assert tempList.get(0) == 13.3;
        assert tempList.size() == 30;
    }
    @Test
    void getMaxValueTest(){
        assert test.getMaxValue(test.readFIleToList()) == 17.5;
        assert test.getMaxValue(test.readFIleToList()) != 17.6;
    }
    @Test
    void getMinValueTest(){
        assert test.getMinValue(test.readFIleToList()) == 6.4;
        assert test.getMinValue(test.readFIleToList()) != 6.5;
    }
    @Test
    void getAverageTest(){
        assert test.getAverage(test.readFIleToList()) == 12.74;
        assert test.getAverage(test.readFIleToList()) != 1.274;
    }
}