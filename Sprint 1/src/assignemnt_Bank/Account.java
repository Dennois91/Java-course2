package assignemnt_Bank;

public class Account extends Client {
    private double balance;
    private double balanceInterestRate;
    private double creditLimit = 0;

    public Account() {
    }

    public Account(double balance, double balanceInterestRate) {
        this.balance = balance;
        this.balanceInterestRate = balanceInterestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 500_000) {
            this.balance = balance;
            this.balanceInterestRate = 0.12;

        } else if (balance < 1_000_000) {
            this.balance = balance;
            this.balanceInterestRate = 1.5;
        } else if (balance > 1_000_000) {
            this.balance = balance;
            this.balanceInterestRate = 2.5;
        }
    }

    public double getBalanceInterestRate() {
        return balanceInterestRate;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void depositToAccount(double deposit) {
        balance = balance + deposit;
    }

    public void withdrawFromAccount(double withdraw) {
        if (withdraw < 50_000) {
            balance = balance + withdraw;
        } else if (balance + withdraw < creditLimit) {
            System.out.println("You dont have enough balance for this withdrawal\n" +
                    "You're balance is: " + getBalance() + ". You're credit limit is set to: " + getCreditLimit());

        }
    }

}
