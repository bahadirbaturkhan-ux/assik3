package model;

public class CheckingAccount extends AccountBase {

    public CheckingAccount(int id, String acc, double bal, Customer c) {
        super(id, acc, bal, c);
    }

    public String getAccountType() {
        return "CHECKING";
    }

    public double calculateMonthlyFee() {
        return 10;
    }
}

