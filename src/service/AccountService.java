package service;

import model.AccountBase;
import repository.AccountRepository;

public class AccountService {
    private final AccountRepository repository = new AccountRepository();

    public void create(AccountBase account) {
        repository.create(account);
    }

    public void showAll() {
        repository.getAll().forEach(System.out::println);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}

