package assignment_3;

import assignment_3.Controller.Controller;
import assignment_3.Model.Login;
import assignment_3.View.View;

import java.io.IOException;

public class Main {

    private void run() throws IOException {
        Controller c = new Controller(new View(), new Login().Login());
        c.InitController();
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
