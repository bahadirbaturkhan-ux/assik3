package model;

public abstract class AccountBase {

    private int id;
    private String accountNumber;
    private double balance;
    private Customer customer;

    protected AccountBase(int id, String accountNumber, double balance, Customer customer) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public abstract String getAccountType();
    public abstract double calculateMonthlyFee();

    public void deposit(double amount) {
        balance += amount;
    }

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }
}


