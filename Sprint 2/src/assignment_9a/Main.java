package assignment_9a;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public Main() {

        Path p = Paths.get("src/assignment_9a/Personuppgifter.txt");
        Path newP = Paths.get("src/assignment_9a/TallPeople.txt");

        List<Person> persons;
        List<Person> tallPersons;

        persons = listToPersonList(fileToList(p));
        tallPersons = onlyTallPeopleList(persons);
        listToFile(tallPersons, newP);
    }

    public List<String> fileToList(Path p) {
        List<String> personuppgifterList = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String temp;
            while ((temp = br.readLine()) != null) {
                personuppgifterList.add(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        }
        return personuppgifterList;
    }

    public List<Person> listToPersonList(List<String> stringList) {
        String[] tempSt = {"", "", ""};
        String[] tempSt2 = {"", "", ""};
        List<Person> personList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < stringList.size() - 1; i += 2) {

            tempSt = stringList.get(i).split(",");
            tempSt2 = stringList.get(i + 1).split(",");

            Person person = new Person(tempSt[0], tempSt[1], tempSt[2],
                    tempSt2[0], tempSt2[1], tempSt2[2]);

            personList.add(person);
        }
        return personList;
    }

    public List<Person> onlyTallPeopleList(List<Person> allPersons) {
        List<Person> tallPeople = new ArrayList<>();
        for (Person person : allPersons) {
            int temp;
            temp = Integer.parseInt(person.height.trim());
            if (temp >= 200) {
                tallPeople.add(person);
            }
        }
        return tallPeople;
    }

    public void listToFile(List<Person> list, Path newP) {

        try (BufferedWriter bw = Files.newBufferedWriter(newP)) {
            for (Person person : list) {
                bw.write(person.name + " " + person.height + "\n");

            }

        } catch (
                FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (
                IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
/*
Uppgift 9a – Inläsning/skrivning till fil
Ladda ner filen Personuppgifter.txt från Nackademins portal.
Filen innehåller personuppgifter. För varje person står personens namn, adress och på nästa rad
personens ålder, längd och vikt. Du ska läsa in filen i ditt program och hitta alla personer som är
längre än 2 meter.
Skapa sedan en ny textfil som bara innehåller uppgifterna för de långa personerna.
Både infilens och utfilens namn ska läsas in av programmet.
Använd try-with-resources
Exempel på personpost i infilen:
Kalle Nilsson, Xvägen 1, 12345 Ystad
25, 80, 175
*/

/*

Att göra:
Läs in filen till en lista
loopa listan. 2 rader sammtidigt. ifall undre raden innehåller +200. spara till en ny lista.
SKriv lista till fil

*/