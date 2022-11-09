package assignment_1a_b_c;

public class Car {
    private CarOwner carOwner;
    private String regId;
    private String make;
    private String brand;

    public Car() {
    }

    public Car(CarOwner carOwner, String regId, String make, String brand) {
        this.carOwner = carOwner;
        this.regId = regId;
        this.make = make;
        this.brand = brand;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "RegId = " + regId +
                " Make = " + make +
                " Brand = " + brand + " " +carOwner;
    }
}
