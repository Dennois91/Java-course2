package assignment_8_extends_7;


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
