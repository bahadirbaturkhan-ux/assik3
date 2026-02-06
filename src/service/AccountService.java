package service;

import model.AccountBase;
import model.SavingsAccount;
import model.CheckingAccount;
import repository.interfaces.CrudRepository;
import exception.InvalidInputException;

import java.util.List;

public class AccountService {

    private final CrudRepository<AccountBase> repository;

    public AccountService(CrudRepository<AccountBase> repository) {
        this.repository = repository;
    }

    public void createAccount(String type,
                              String accountNumber,
                              double balance,
                              int customerId) throws InvalidInputException {

        if (balance < 0) {
            throw new InvalidInputException("Balance cannot be negative");
        }

        AccountBase account;

        if ("savings".equalsIgnoreCase(type)) {
            account = new SavingsAccount(0, accountNumber, balance);
        } else if ("checking".equalsIgnoreCase(type)) {
            account = new CheckingAccount(0, accountNumber, balance);
        } else {
            throw new InvalidInputException("Unknown account type");
        }

        if (!account.validate()) {
            throw new InvalidInputException("Invalid account data");
        }

        repository.create(account, customerId);
    }

    public List<AccountBase> getAllAccounts() {
        return repository.findAll();
    }
}
