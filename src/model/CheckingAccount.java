package model;

public class CheckingAccount extends AccountBase {
    public CheckingAccount(int id, String accountNumber, double balance, Customer customer) {
        super(id, accountNumber, balance, customer);
    }

    public String getAccountType() {
        return "CHECKING";
    }

    public double calculateMonthlyFee() {
        return 10;
    }
}

