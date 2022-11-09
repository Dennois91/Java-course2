package assignment_9a;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class MainTest {

    Main test = new Main();
    Path p = Paths.get("src/assignment_9a/Personuppgifter.txt");
    Path newP = Paths.get("src/assignment_9a/TallPeople.txt");
    @Test
    void listToFileTest() {
        try (Scanner scanner = new Scanner(newP)) {
            assert scanner.nextLine().equals("Rulle Rullson  201");
        } catch (IOException ignored) {
        }
    }
    @Test
    void fileToListTest() {
        assert (test.fileToList(p).size()) == 16;
        assert test.fileToList(p).get(0).equals("Kalle Nilsson, Xvägen 1, 12345 Ystad");
        assert test.fileToList(p).get(1).equals("25, 80, 175");
        assert !test.fileToList(p).isEmpty();
    }
    @Test
    void listToPersonListTest() {
        List<Person> persons = test.listToPersonList(test.fileToList(p));
        assert persons.size() == 8;
        assert persons.get(0).name.equals("Kalle Nilsson");
        assert !persons.get(0).name.equals("lottamulle");
    }
    @Test
    void onlyTallPeopleListTest() {
        List<Person> persons = test.listToPersonList(test.fileToList(p));
        List<Person> tallPersons = test.onlyTallPeopleList(persons);
        for (Person person : tallPersons) {
            int temp;
            temp = Integer.parseInt(person.height.trim());
            assert temp >= 200;
        }
    }
}
/*
Läs in filen till en lista *
Skapa klass person *
Läst listen med personuppgifter. Loopa listan. 2 rader sammtidigt. och skapa en lista med Personer *
Skapa en ny lista AV listan med ALLA personer. Som enbart inehåller personer över 2M *
Skriv listan med personer över 2m till fil.
 */