package examination_2;

import java.time.LocalDate;

public class Person {
    protected String id;
    protected String name;
    protected LocalDate payedDate;

    public Person(String id, String name, LocalDate payedDate) {
        this.id = id;
        this.name = name;
        this.payedDate = payedDate;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getPayedDate() {
        return payedDate;
    }
}
