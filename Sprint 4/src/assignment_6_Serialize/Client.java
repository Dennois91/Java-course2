package assignment_6_Serialize;

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
            fromServer = in.readObject();
            System.out.println(fromServer);

            while ((input = userInput.readLine()) != null) {
                out.println(input);
                System.out.println("message sent to server: " + input);

                fromServer = in.readObject();
                if (fromServer instanceof Person p) {
                    System.out.println(p.getName() + "  " + p.getIdNr() + "  " + p.getAdress() + "  " + p.getPhone());

                } else if (fromServer instanceof String) {
                    System.out.println(fromServer);
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
