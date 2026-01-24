package controller;

import model.AccountBase;
import service.AccountService;

public class BankController {
    private final AccountService service = new AccountService();

    public void create(AccountBase account) {
        service.create(account);
    }

    public void showAll() {
        service.showAll();
    }

    public void delete(int id) {
        service.delete(id);
    }
}
