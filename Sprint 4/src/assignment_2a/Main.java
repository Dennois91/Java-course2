package assignment_2a;

import java.io.IOException;

public class Main {

    private void run() throws IOException, InterruptedException {
        Thread sender = new Thread(new DatagramSender());
        Thread receiver = new Thread(new DatagramReceiver());
        sender.start();
        receiver.start();

        Thread.sleep(7000);
        System.exit(0);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Main().run();

    }
}



