package assignment_3d;

abstract class Person {

    protected String name;
    protected int idNumber;

    public Person() {
    }

    public Person(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }
    public String getName() {
        return name;
    }
}
