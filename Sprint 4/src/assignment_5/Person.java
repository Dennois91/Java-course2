package assignment_5;

public class Person {
    private String name;
    private String adress;
    private String phone;
    private String idNr;

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
