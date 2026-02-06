package model;

public class CheckingAccount extends AccountBase {

    public CheckingAccount(int id, String accountNumber, double balance) {
        super(id, accountNumber, balance);
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public String getAccountType() {
        return "CHECKING";
    }
}

