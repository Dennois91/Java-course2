package examination_2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

class ClientManagerTest {

    ClientManager cm = new ClientManager();
    Path testClientPath = Paths.get("test/examination_2/customerTest.txt");
    Path testPtLoggPath = Paths.get("test/examination_2/ptLoggTest.txt");
    List<String> s = cm.fileToList(testClientPath);
    List<Person> clients = cm.listToClientList(s);
    String testStringPathPtLogg = "test/examination_2/ptLoggTest.txt";


    @BeforeAll
    public static void resetTests() {
        try {
            Files.deleteIfExists(Paths.get("test/examination_2/ptLoggTest.txt"));
        } catch (IOException e) {
            System.out.println("Could not reset test files");
            e.printStackTrace();
        }
    }

    @Test
    void fileToListTest() {
        assert (cm.fileToList(testClientPath).size()) == 4;
        assert cm.fileToList(testClientPath).get(0).equals("7502031234, Anna Andersson");
        assert cm.fileToList(testClientPath).get(1).equals("2022-05-03");
        assert !cm.fileToList(testClientPath).isEmpty();
    }

    @Test
    void listToClientListTest() {
        assert (cm.listToClientList(s).size()) == 2;
        assert cm.listToClientList(s).get(0).name.equals("Anna Andersson");
        assert cm.listToClientList(s).get(1).name.equals("Fritjoff Flacon");
        assert !cm.listToClientList(s).isEmpty();

    }

    @Test
    void seeIfMemberTest() {
        String id = "7911061234"; //Fritjoff's ID
        assert cm.seeIfMember(clients, id);
        id = "31234 7911";
        assert !cm.seeIfMember(clients, id);

    }

    @Test
    void idOfClients() {                       //All ID's in a string
        assert cm.idOfClients(clients).equals("7502031234 7911061234 ");
        assert !cm.idOfClients(clients).isEmpty();
    }

    @Test
    void matchClientToId() {
        String id = "7911061234"; //Fritjoff's ID
        assert cm.matchClientToId(clients, id).equals(clients.get(1));
        assert !cm.matchClientToId(clients, id).equals(clients.get(0));
    }

    @Test
    void isActive() {
        assert cm.isActive(clients.get(0));
        assert !cm.isActive(clients.get(1));
    }

    @Test
    void clientToFile() {
        cm.clientToFile(clients.get(0), testStringPathPtLogg);
        cm.clientToFile(clients.get(1), testStringPathPtLogg);
        try (Scanner testSc = new Scanner(Files.newBufferedReader(testPtLoggPath))) {
            assert !testSc.nextLine().isEmpty();
            assert testSc.nextLine().contains("Fritjoff");

        } catch (IOException e) {
            System.out.println("Error in test clientToFileTest");
            e.printStackTrace();
        }
    }
}

