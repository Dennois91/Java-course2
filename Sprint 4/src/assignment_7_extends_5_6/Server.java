package assignment_7_extends_5_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    Database d = new Database();

    public Server() {
        System.out.println("server running");

        try (ServerSocket ss = new ServerSocket(55556);
             Socket s = ss.accept();
             ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))
        ) {
            out.writeObject(new Intro());

            String request;
            while ((request = in.readLine()) != null){
                Person answer = d.search(request.trim());
                if(answer == null){
                out.writeObject(new Response(false));
                }
                out.writeObject(new Response(true,answer));
            }
        }catch (IOException e ){
            e.printStackTrace();
            System.out.println("server didnt start");
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
