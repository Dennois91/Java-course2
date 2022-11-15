package assignment_1.TCP;

public class Main {
    private void Run() throws InterruptedException {
        new Server().start();
        Thread.sleep(1000);
        new Client().start();
    }

    public static void main(String[] args) throws InterruptedException {
        new Main().Run();
    }
}
