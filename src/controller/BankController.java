package controller;

import model.AccountBase;
import service.AccountService;

public class BankController {

    private final AccountService service = new AccountService();

    public void create(AccountBase account) {
        service.createAccount(account);
        System.out.println("Account created");
    }

    public void showAll() {
        service.showAllAccounts();
    }

    public void delete(int id) {
        service.deleteAccount(id);
        System.out.println("Account deleted");
    }
}
