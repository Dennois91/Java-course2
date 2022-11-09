package assignemnt_Bank;

import java.util.ArrayList;
import java.util.List;

public class Loan extends Client {
    private double size;
    private double loanInterestRate;
    private Employee loanIssuer;

    private List<Employee> interestRateChangeByEmployeeHistory = new ArrayList<>();
    private List<Double> interestRateHistory = new ArrayList<>();

    public Loan(int size, double loanInterestRate, Employee loanIssuer) {
        this.size = size;
        this.loanInterestRate = loanInterestRate;
        this.loanIssuer = loanIssuer;
    }

    public void changeInterestRate(Employee interestIssuer, double newInterestRate) {
        interestRateChangeByEmployeeHistory.add(interestIssuer);
        interestRateHistory.add(newInterestRate);

    }

    public void printLoanHistory(Loan loan) {
        for (int i = 0; i < interestRateChangeByEmployeeHistory.size(); i++) {
            System.out.print(interestRateChangeByEmployeeHistory.get(i).getName() + " Changed rate to " +
                    interestRateHistory.get(i) + "\n");
        }
        System.out.println("Current rate is " +interestRateHistory.get(interestRateHistory.size()-1));
    }
}
