package assignemnt_Bank;

public class Employee extends People {

    private double salary;

    public Employee(String name, String personalID, int salary) {
        super(name, personalID);
        this.salary = salary;
    }

    public String getName() {
        return super.getName();
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
