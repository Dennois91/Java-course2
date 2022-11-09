package examination_2;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public Main() {
        final String ANSI_RED = "\u001B[41m";
        final String ANSI_GREEN = "\u001B[42m";
        final String ANSI_RESET = "\u001B[0m";

        Path clientFile = Paths.get("src/examination_2/customers.txt");  //Filen som data ska hämtas ifrån.
        ClientManager cm = new ClientManager();  //ClientManager innehåller alla metoder för att manipulera data.
        List<Person> clients;
        List<String> strings;
        strings = cm.fileToList(clientFile);     //Börjar med att läsa in datat tille en lista av string.
        clients = cm.listToClientList(strings);  //Omvandlar string listan till en lista med Personer.
        String input;

        while (true) {
            input = JOptionPane.showInputDialog(null,
                    "Enter ID of client. 10 digits Format 1122334444: \n" +
                            "If no client is found. Database of clients will be printed.");
            if (input == null) {
                System.out.print("Shutting down");
                break;
            }

            if (cm.seeIfMember(clients, input)) {   //Om ID som skrivs in finns i databasen kommer programmet köras
                Person tempClient;
                tempClient = cm.matchClientToId(clients, input);
                if (cm.isActive(tempClient)) {      //Tittar ifall kunden fortfarande är aktiv. Om så är fallet.
                    System.out.println(tempClient.getName() + " Saved to the pt loggbok"); //Skrivs person till ptLogg
                    String tempPath = "src/examination_2/ptLogg.txt";
                    cm.clientToFile(tempClient, tempPath);
                } else {
                    System.out.println(tempClient.getName() + ". You're membership is inactive!");
                }
                            //Om ID som anges aldrig varit medlem kommer istället en lista ut på alla kunder i systemet.
            } else {
                System.out.println("\nCant find '" + input + "' in system");
                System.out.println("Clients currently in system \n");
                for (Person client : clients) {
                    if (cm.isActive(client)) {
                        System.out.println(ANSI_GREEN + client.getId() + " " + client.getName() + " " +
                                "Active membership. Last payed date: " + client.getPayedDate() + ANSI_RESET);
                    } else if (!cm.isActive(client)) {
                        System.out.println(ANSI_RED + client.getId() + " " + client.getName() + " " +
                                "Membership expired. Last payed date: " + client.getPayedDate() + ANSI_RESET);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
