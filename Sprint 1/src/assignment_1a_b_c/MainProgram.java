package assignment_1a_b_c;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProgram {
    Person[] people = new Person[4];
    CarOwner owner1 = new CarOwner("Gunnar Gunnarsson", "Handen", 20);
    CarOwner owner2 = new CarOwner("Ingmar Ingemarsson", "Trosa", 25);
    CarOwner owner3 = new CarOwner("Ulla Britta", "Fittja", 30);
    CarOwner carDealership = new CarOwner("Bilexpressen", "xxxx", 0);
    Car[] cars = new Car[4];
    Car car1 = new Car(carDealership, "ABC123", "M3", "BMW");
    Car car2 = new Car(carDealership, "EFG456", "M2", "BMW");
    Car car3 = new Car(carDealership, "AAA111", "V70", "VOLVO");
    Car car4 = new Car(carDealership, "BBB222", "9000", "SAAB");

    int ownedCars1 = 0;
    int ownedCars2 = 0;
    int ownedCars3 = 0;
    int ownedCarsDealer = 4;

    public static void main(String[] args) {
        MainProgram mainProgram = new MainProgram();
    }


    MainProgram() {

        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;
        cars[3] = car4;
        people[0] = owner1;
        people[1] = owner2;
        people[2] = owner3;
        people[3] = carDealership;

        while (true) {

            switch (WelcomeMeny()) {
                case 1 -> {
                    PresentCars();
                    if (ownedCarsDealer <= 0) {
                        System.out.println("No more cars for sale");

                    } else {
                        cars[SelectCar()].setCarOwner(owner1);
                        ownedCars1++;
                        ownedCarsDealer--;
                    }
                }
                case 2 -> {
                    PresentCars();
                    if (ownedCarsDealer <= 0) {
                        System.out.println("No more cars for sale");

                    } else {
                        cars[SelectCar()].setCarOwner(owner2);
                        ownedCars2++;
                        ownedCarsDealer--;
                    }
                }
                case 3 -> {
                    PresentCars();
                    if (ownedCarsDealer <= 0) {
                        System.out.println("No more cars for sale");

                    } else {
                        cars[SelectCar()].setCarOwner(owner3);
                        ownedCars3++;
                        ownedCarsDealer--;
                    }
                }
                case 4 -> Owners();

                default -> {
                }
            }
        }
    }

    public int WelcomeMeny() {
        System.out.println("Welcome to Bilexpressens car dealership");
        System.out.println("Who am i talking to?");
        System.out.println("Press 1 for Gunnar");
        System.out.println("Press 2 for Ingemar");
        System.out.println("Press 3 for Ulla");
        System.out.println("Press 4 for List of owners");
        var scan = new Scanner(System.in);
        int input = 0;

        try {
            input = scan.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Error occurred because of " + e);
        }
        return input;
    }

    public void PresentCars() {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getCarOwner() == carDealership) {
                System.out.println("Car in lot nr >" + i + "< is for sale: " + cars[i]);
            } else {
                System.out.println("Car in lot nr >" + i + "< is sold");
            }
        }
    }

    public int SelectCar() {
        System.out.println("Which car would you like to buy? Type lot nr of the car you wish to purchase");
        var scan = new Scanner(System.in);
        int carInput = 0;
        try {
            carInput = scan.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Error occurred because of " + e);
        }
        return carInput;
    }

    public void Owners() {
        for (Car car : cars) {
            System.out.println("Car with ID " + car.getRegId() + " is owned by " + car.getCarOwner());
        }
    }
}