package assignment_4;

import org.junit.jupiter.api.Test;

class CarTest {

   Car car = new Car(2000, 1000, 1000);

    @Test
    void milesDriven() {
        assert car.mileage - car.mileageOneYearAgo == 1000;
        assert car.milesDriven() == 1000;
        assert car.milesDriven() != 100;
    }
    @Test
    void milesDrivenString(){
        assert car.milesDrivenString().equals( "Antal körda mil: " + car.milesDriven());
        assert !car.milesDrivenString().equals("Atalhakama");
    }

    @Test
    void litersOfGasUsed() {
        assert car.litersOfGasUsed() == car.yearlyGasTotal;
        assert car.litersOfGasUsed() != 900;
    }
    @Test
    void litersOfGasString(){
        assert car.litersOfGasString().equals("Antal liter bensin: " + car.litersOfGasUsed());
        assert !car.litersOfGasString().isEmpty();
    }

    @Test
    void literPer10Km() {
        assert car.milesDriven() / car.litersOfGasUsed() == 1;
        assert car.milesDriven() != 50;
    }
    @Test
    void literPer10KmString(){
        assert car.literPer10KmString().equals("Förbrukning per mil: " + car.literPer10Km());
        assert !car.literPer10KmString().isEmpty();
    }
}
