package assignment_1;

import java.io.IOException;

public class Main {

    public Main() throws InterruptedException {

        var thread1 = new Thread(new Server());
        var thread2 = new Thread(new Client());
        thread2.start();
        thread1.start();

        System.out.println("System running. Main sleep 5 sec");
        Thread.sleep(5000);

        thread2.interrupt();
        Thread.sleep(1100);
        thread1.interrupt();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Main();
    }
}
