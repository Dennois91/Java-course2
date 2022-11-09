package kladdpapper;

import java.io.IOException;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        InetAddress myIp = InetAddress.getLocalHost();
        System.out.println(myIp);
        System.out.println(myIp.getHostName());
        System.out.println(myIp.getHostAddress());

        InetAddress myIpToConnect = InetAddress.getByName("192.168.0.102");
        System.out.println(myIpToConnect);

        InetAddress myIpTo3 = InetAddress.getLoopbackAddress();
        System.out.println(myIpTo3);

        String message = "Hello";
        byte[] data = message.getBytes();
        System.out.println(data);
    }
}
