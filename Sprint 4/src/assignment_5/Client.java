package assignment_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public Client() {

        try (Socket s = new Socket("127.0.0.1", 55556);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.println(in.readLine());
            String input = "";

            while ((input = userInput.readLine()) != null) {
                out.println(input);
                System.out.println("message sent to server: " + input);

                System.out.println(in.readLine());
            }


        } catch (IOException e) {

        }

    }

    public static void main(String[] args) {
        new Client();
    }
}
