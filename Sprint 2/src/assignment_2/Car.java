package assignment_2;

public class Car {

    double mileage;
    double mileageOneYearAgo;
    double yearlyGasTotal;

    public Car() {
    }

    public Car(double mileage, double mileageOneYearAgo, double yearlyGasTotal) {
        this.mileage = mileage;
        this.mileageOneYearAgo = mileageOneYearAgo;
        this.yearlyGasTotal = yearlyGasTotal;
    }

    public double milesDriven() {
        return mileage - mileageOneYearAgo;
    }

    public double litersOfGasUsed() {
        return yearlyGasTotal;
    }

    public double literPer10Km() {
        return litersOfGasUsed() / milesDriven();
    }

    public String milesDrivenString() {
        return "Antal körda mil: " + milesDriven();
    }

    public String litersOfGasString() {
        return "Antal liter bensin: " + litersOfGasUsed();
    }

    public String literPer10KmString() {
        return "Förbrukning per mil: " + literPer10Km();
    }
}
