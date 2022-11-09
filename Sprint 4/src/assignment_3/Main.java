package assignment_3;


import java.io.IOException;

public class Main {
    private void run() throws IOException {
        new Controller(new View()).InitController();

    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
