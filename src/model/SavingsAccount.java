package model;

public class SavingsAccount extends AccountBase {
    public SavingsAccount(int id, String accountNumber, double balance, Customer customer) {
        super(id, accountNumber, balance, customer);
    }

    public String getAccountType() {
        return "SAVINGS";
    }

    public double calculateMonthlyFee() {
        return 0;
    }
}

