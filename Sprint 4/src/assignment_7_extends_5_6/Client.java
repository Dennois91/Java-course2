package assignment_7_extends_5_6;

import java.io.*;
import java.net.Socket;

public class Client {

    private void Run() {

        try (Socket s = new Socket("127.0.0.1", 55556);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             ObjectInputStream in = new ObjectInputStream(s.getInputStream());
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String input;
            Object fromServer;

            while ((fromServer = in.readObject()) != null) {

                if (fromServer instanceof Intro) {
                    System.out.println("Connection initiated");

                } else if (fromServer instanceof Response) {
                    if (!((Response) fromServer).isSuccess()) {
                        System.out.println("No match in system");
                    } else {
                        System.out.println(((Response) fromServer).getPerson().getAdress());
                    }
                }
                System.out.println("Enter name to search database: ");
                input = userInput.readLine();
                if (input != null) {
                    out.println(input);
                }
            }
        } catch (IOException ignored) {
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Client().Run();
    }
}
