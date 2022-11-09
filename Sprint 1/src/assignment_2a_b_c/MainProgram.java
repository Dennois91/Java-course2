package assignment_2a_b_c;

public class MainProgram {
    Vehicle[] vehicles = new Vehicle[4];
    Car car1 = new Car(100, 1200, 5, 2);
    Boat boat1 = new Boat(30, 2000, 3600);
    Train train1 = new Train(60, 5000, 7);
    Bicycle bicycle1 = new Bicycle(20, 15, 21, 15);


    public MainProgram() {
        vehicles[0] = car1;
        vehicles[1] = boat1;
        vehicles[2] = train1;
        vehicles[3] = bicycle1;
        PrintAllVehicleData(vehicles);

    }

    public static void main(String[] args) {
        MainProgram mainProgram = new MainProgram();
    }

    public void PrintAllVehicleData(Vehicle[] vehicles) {
        for (Vehicle vehicle :vehicles) {
            vehicle.PrintMe();
        }
        System.out.print("Nr of wheels on car = ");
        car1.getNrOfWheels();
        System.out.print("Nr of wheels on bicycle = ");
        bicycle1.getNrOfWheels();
    }
}
