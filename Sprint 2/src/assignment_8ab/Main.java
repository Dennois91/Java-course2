package assignment_8ab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public Main() {

        String tempLine;
        int counter = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double total = 0;

        try (FileReader fr = new FileReader("src/assignment_8ab/temp.txt");
             BufferedReader buf = new BufferedReader(fr)) {
            while ((tempLine = buf.readLine()) != null) {
                counter++;
                String replace;
                replace = tempLine.replaceAll(",", ".");
                double temp;
                temp = Double.parseDouble(replace);
                total = total + temp;

                if (temp < min) {
                    min = temp;
                } else if (temp > max) {
                    max = temp;
                }
            }
            System.out.println("Min temp is " + min + "\n" +
                    "Max temp is " + max + "\n" +
                    "Avrage temp is " + total / counter);

        } catch (FileNotFoundException e) {
            System.out.println("File not found Exception");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("IOException");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

    }
}
/*

Skriv ett program som läser filen och skriver ut högsta och lägsta värden, samt beräknar
medeltemperaturen för månaden.
Använd dig av klassen FileReader wrappad i en BufferedReader för att läsa från filen.

*/