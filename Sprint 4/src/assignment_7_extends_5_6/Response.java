package assignment_7_extends_5_6;


import java.io.Serializable;

public class Response implements Serializable {

    private final boolean success;
    private Person person;

    public Response(boolean b) {
        success = b;
    }

    public Response(boolean b, Person person) {
        success = b;
        this.person = person;
    }

    public boolean isSuccess() {
        return success;
    }

    public Person getPerson() {
        return person;
    }
}
