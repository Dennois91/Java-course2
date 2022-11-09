package examination_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientManager {

    protected List<String> fileToList(Path p) {
        List<String> clients = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String temp;
            while ((temp = br.readLine()) != null) {
                clients.add(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        }
        return clients;
    }

    protected List<Person> listToClientList(List<String> stringList) {
        String[] tempSt;
        String tempSt2;
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < stringList.size() - 1; i += 2) {

            tempSt = stringList.get(i).split(",");
            tempSt2 = stringList.get(i + 1);

            Person person = new Person(tempSt[0].trim(), tempSt[1].trim(), LocalDate.parse(tempSt2));

            personList.add(person);
        }
        return personList;
    }

    protected String idOfClients(List<Person> clients) {
        StringBuilder idOfClients = new StringBuilder();
        for (Person client : clients) {
            idOfClients.append(client.id).append(" ");
        }
        return idOfClients.toString();
    }

    protected boolean seeIfMember(List<Person> clients, String id) {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(id.trim());
        String allClientsId = idOfClients(clients);
        return matcher.matches() && allClientsId.contains(id.trim());
    }

    protected Person matchClientToId(List<Person> p, String id) {
        Person current = new Person();
        for (Person person : p) {
            if (person.getId().equals(id.trim())) {
                current = person;
            }
        }
        return current;
    }

    protected boolean isActive(Person client) {
        LocalDate ld = LocalDate.now();
        LocalDate past = client.payedDate;
        Period period = Period.between(ld, past);
        int membership = period.getYears();
        if (membership < 0) {
            membership = membership * -1;
        }
        return membership <= 0;
    }

    protected void clientToFile(Person client, String path) {
        File file = new File(path);

        try (FileWriter fw = new FileWriter(file, true)) {

            LocalDate ld = LocalDate.now();
            String temp;
            temp = (client.getId() + ". " + client.getName() + ". Trained: " + ld + ".\n");
            fw.write(temp);

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
}
