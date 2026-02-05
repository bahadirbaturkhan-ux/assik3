package controller;

import model.AccountBase;
import service.AccountService;

public class BankController {

    private final AccountService service;

    public BankController(AccountService service) {
        this.service = service;
    }

    public void create(AccountBase a) {
        service.create(a);
    }

    public void delete(int id) {
        service.delete(id);
    }
}

