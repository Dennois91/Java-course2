package assignment_5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    Database d = new Database();

    public Server() {
        System.out.println("server running");

        try (ServerSocket ss = new ServerSocket(55556);
             Socket s = ss.accept();
             PrintWriter out = new PrintWriter(s.getOutputStream(),true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        ) {
            out.println("Connected to server. Enter name to search database");

            String request = "";
            while ((request = in.readLine()) != null){
                String answer = d.search(request).trim();
                out.println(answer);
            }
        }catch (IOException e ){
            System.out.println("server start inte");

        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
