package assignemnt_Bank;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainProgram {
    Bank handelsbanken = new Bank();
    Client dennis = new Client("Dennis", "19910715");
    Account account = new Account(600000, 0);


    public MainProgram() {
        int clientCounter = 0;
        dennis.addAccount(account);
        handelsbanken.addClients(dennis);

        System.out.println("Welcome to handelsbanken");
        boolean loop = true;
        while (loop) {

            switch (welcomeMenu()) {
                case 1 ->
                    //To become a client press '1'
                        becomeClient();

                case 2 -> {
                    //If already a client press '2'
                    if (!handelsbanken.getListOfClients().isEmpty()) {
                        Client currentClient = whoAreYou();
                        switch (clientMenu()) {
                            case 1 -> {  //To manage accounts press '1'
                                int accounts = manageAccounts(currentClient);
                                System.out.print("Which account? Enter digit: ");



                            }
                            case 2 -> {
                                System.out.println(2);
                                //To manage loans press '2'

                            }
                            case 3 -> {
                                System.out.println(3);
                                //To open new account press '3'

                            }
                            case 4 -> {
                                System.out.println(4);
                                //To apply for new loan press '4'

                            }
                            case 5 -> {
                                System.out.println(5);
                                //To exit press '5'

                            }
                        }
                    } else {
                        System.out.println("The bank is new. It currently have 0 clients.\n" +
                                "Become a client and join us for a wealthier future today!");
                    }
                }
                /*
                EV. CASE 3
                IF EMPLOYEE PRESS 3
                   WHO ARE YOU?
                     LIST GRANTED LOANS.
                */
                /*
                EV. CASE 4
                LISTA BANKENS KUNDER OCH ANST??LLDA.
                */

                case 3 -> {
                    //Exit program '3'
                    System.out.println("Exiting program. Bye.");
                    loop = false;
                }
                default -> System.out.println("Invalid input. Use presented numbers only");
            }
        }
    }

    public int manageAccounts(Client currentClient) {
        int counter = 0;
        System.out.println("You're accounts");
        for (Account account : currentClient.getAccountsList()) {
            counter++;
            System.out.println("[" + counter + "] " + account.getBalance() +
                    " " + account.getBalanceInterestRate() + "% Interest");
        }
        return counter;
    }


    public int clientMenu() {
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("To manage accounts press '1'\n" +
                "To manage loans press '2'\n" +
                "To open new account press '3'\n" +
                "To apply for new loan press '4'\n" +
                "To exit press '5'");
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
        return input;
    }

    public Client whoAreYou() {
        String input;
        Client currentClient = new Client();
        while (true) {

            System.out.print("Enter youre ID number 8 digits: \n");
            System.out.println("To return enter 1");
            Scanner scanner = new Scanner(System.in);
            input = scanner.next();
            Pattern pattern = Pattern.compile("^[0-9]{8}$");
            Matcher matcher = pattern.matcher(input);
            String allClientsId = getIdOfBankClient(handelsbanken);
            if (matcher.matches() && allClientsId.contains(input)) {
                currentClient = matchIdToClient(input);
                System.out.print("Welcome back ");
                System.out.println(currentClient.getName() + " " + currentClient.getId());
                break;

            } else if (input.equals("1")) {

                break;

            } else {
                System.out.println("I am sorry. We cant find you in our database.");
            }
        }
        return currentClient;
    }

    public Client matchIdToClient(String id) {
        Client current = new Client();
        for (Client client : handelsbanken.getListOfClients()) {
            if (client.getId().equals(id)) {
                current = client;
            }
        }
        return current;
    }

    public void becomeClient() {
        Client client;
        String name;
        String iD;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your'e name: ");
        name = scanner.next();
        name.trim();
        System.out.print("Enter your'e iD number: ");
        iD = scanner.next();
        iD.trim();
        Pattern pattern = Pattern.compile("^[0-9]{8}$");
        Matcher matcher = pattern.matcher(iD);
        if (matcher.matches()) {
            System.out.println("Valid id");
        } else {
            System.out.println("Invalid ID. use format 19995511 total of 8 characters");
        }
        client = new Client(name, iD);
        handelsbanken.addClients(client);


        //^[0-9]{8}$


    }

    public int welcomeMenu() {
        int input = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "To become a client press '1'\n" +
                        "If already a client press '2'\n" +
                        "To exit press '3'");
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
        return input;
    }


    public void getNameOfBankEmployees(Bank bank) {
        for (Employee employee : bank.getListOfEmployees()) {
            System.out.println("Employee: " + employee.getName() + "  " + employee.getSalary());
        }
    }

    public void getNameOfBankClients(Bank bank) {
        for (Client client : bank.getListOfClients()) {
            System.out.println("Client: " + client.getName());
        }
    }

    public String getIdOfBankClient(Bank bank) {
        String allClients = "";
        for (Client client : bank.getListOfClients()) {
            allClients = allClients + client.getId();
        }
        return allClients;
    }

    public static void main(String[] args) {
        MainProgram mainProgram = new MainProgram();

    }
}
/*
Uppgift 10 ??? Bankomaten (finns inte i facit)
Ni har f??tt i uppgift att designa ett banksystem.
Systemet beh??ver h??lla reda p?? f??ljande
??? Vilka kunder banken har
??? Bankens personal, med personuppgifter och l??n
??? Vilka konton och l??n varje kund har (en kund kan ha flera konton och l??n)
??? R??ntesats och saldo p?? varje konto
??? R??ntesats och belopp p?? varje l??n
??? Det ska g?? att se vilken anst??lld som har beviljat varje l??n
??? Det ska finnas historik ??ver r??nte??ndringar och vilken anst??lld som beviljade ??ndringen

G??r diagram ??ver vilka klasser och interface som beh??ver finnas
I varje klass, skriv ut vilka instansvariabler och instansmetoder som ska finnas. Markera om de ??r
private/public eller protected
Implementera objektmodellen till ditt system, allts??, skriv alla klasser och interface i kod.
Vi kommer att bygga vidare p?? denna uppgift i varje sprint!
*/