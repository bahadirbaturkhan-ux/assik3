package model;

public abstract class AccountBase {

    protected int id;
    protected String accountNumber;
    protected double balance;
    protected Customer customer;

    public AccountBase(int id, String accountNumber, double balance, Customer customer) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public abstract String getAccountType();
    public abstract double calculateMonthlyFee();

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
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
