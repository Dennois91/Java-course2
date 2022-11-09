package assignment_3;

import java.util.Scanner;

public class Main {
    public Main() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String temp;
            System.out.println("Enter a string");
            temp = scanner.nextLine();
            System.out.println("You typed: " + temp);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}

