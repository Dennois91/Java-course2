package assignment_8ab;

import javax.sound.midi.Soundbank;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainB {

    public MainB() {
        System.out.println("Max value is: " + getMaxValue(readFIleToList()));
        System.out.println("Min value is: " + getMinValue(readFIleToList()));
        System.out.println("Avrage value is: " + getAverage(readFIleToList()));
    }

    public List<Double> readFIleToList() {
        List<Double> tempList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader("src/assignment_8ab/temp.txt"))) {
            while (scanner.hasNextDouble()) {
                tempList.add(scanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unspecified Exception");
            e.printStackTrace();
        }
        return tempList;
    }

    public double getMaxValue(List<Double> allNumbers) {
        double max = Double.MIN_VALUE;
        for (Double d : allNumbers) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    }

    public double getMinValue(List<Double> allNumbers) {
        double min = Double.MAX_VALUE;
        for (Double d : allNumbers) {
            if (d < min) {
                min = d;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MainB mainB = new MainB();
    }

    public double getAverage(List<Double> allNumbers) {
        double temp =0;
        int counter =0;
        for (Double d :allNumbers){
            counter++;
            temp = temp + d;
        }
        return temp/counter;
    }
}
//Kopiera uppgift 8a. Modifiera koden så att du använder dig av Scanner för att läsa från filen.