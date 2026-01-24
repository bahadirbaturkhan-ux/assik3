package service;

import model.AccountBase;
import repository.AccountRepository;

public class AccountService {

    private final AccountRepository repository = new AccountRepository();

    public void createAccount(AccountBase account) {
        repository.create(account);
    }

    public void showAllAccounts() {
        repository.getAll().forEach(System.out::println);
    }

    public void deleteAccount(int id) {
        repository.delete(id);
    }
}
