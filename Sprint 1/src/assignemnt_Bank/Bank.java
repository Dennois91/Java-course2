package assignemnt_Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> clients = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public void addClients(Client client) {
        clients.add(client);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Client> getListOfClients() {
     return clients;
    }
    public List<Employee> getListOfEmployees(){
        return employees;
    }
}
