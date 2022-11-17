package assignment_12_TCP_Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStarter {

    MultiCaster multiCaster = new MultiCaster();

    public ServerStarter() {
        try (ServerSocket ss = new ServerSocket(44444);){
            while (true){
                Socket s = ss.accept();
                Server serv = new Server(s,multiCaster);
                serv.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new ServerStarter();
    }
}
