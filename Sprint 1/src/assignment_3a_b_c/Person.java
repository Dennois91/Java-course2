package assignment_3a_b_c;

abstract class Person {

    protected String name;

    public Person(String name, int idNumber) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
