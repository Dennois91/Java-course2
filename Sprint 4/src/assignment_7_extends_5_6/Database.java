package assignment_7_extends_5_6;

import java.util.List;

public class Database {

    Person client1 = new Person("Dennis", "Spelvägen 19", "445566", "19910715");

    Person client2 = new Person("Ulla", "Snorresund 22", "665544", "19911122");

    Person client3 = new Person("Bella", "Muttelunda 44", "999777", "20000606");

    Person client4 = new Person("Mogge", "Litebakomkulla 98", "3332", "19980909");

    List<Person> register = List.of(client1, client2, client3, client4);

    public Database() {
    }

    public Person search(String name) {
        for (Person p : register) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
