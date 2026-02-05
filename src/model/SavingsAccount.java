package model;

public class SavingsAccount extends AccountBase {

    public SavingsAccount(int id, String acc, double bal, Customer c) {
        super(id, acc, bal, c);
    }

    public String getAccountType() {
        return "SAVINGS";
    }

    public double calculateMonthlyFee() {
        return 0;
    }
}

