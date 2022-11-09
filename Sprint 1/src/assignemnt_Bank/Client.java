package assignemnt_Bank;

import java.util.ArrayList;
import java.util.List;

public class Client extends People {


    private List<Account> accounts = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public Client(String name, String personalID, List<Account> accounts, List<Loan> loans) {
        super(name, personalID);
        this.accounts = accounts;
        this.loans = loans;
    }

    public Client(String name, String personalID) {
        super(name, personalID);
    }

    public Client() {
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccountsList() {
        return accounts;
    }
    public void addLoan(Loan loan){
        this.loans.add(loan);
    }
    public List<Loan> getLoansList(){
        return loans;
    }

    public String getName() {
        return super.getName();
    }
    public String getId(){
        return super.getiD();
    }
}
