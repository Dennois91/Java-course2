package assignment_10;

import java.io.Serializable;

public class Person implements Serializable {
    private final String name;
    private final String adress;
    private final String phone;
    private final String idNr;

    public Person(String name, String adress, String phone, String idNr) {
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.idNr = idNr;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdNr() {
        return idNr;
    }
}
