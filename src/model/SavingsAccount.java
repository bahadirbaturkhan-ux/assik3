package model;

public class SavingsAccount extends AccountBase {

    public SavingsAccount(int id, String accountNumber, double balance) {
        super(id, accountNumber, balance);
    }

    @Override
    public boolean validate() {
        return balance >= 0;
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }
}


