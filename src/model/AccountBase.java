package model;

public abstract class AccountBase {

    protected int id;
    protected String accountNumber;
    protected double balance;

    public AccountBase(int id, String accountNumber, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract boolean validate();
    public abstract String getAccountType();

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}


