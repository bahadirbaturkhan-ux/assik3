package service;

import model.AccountBase;
import repository.interfaces.CrudRepository;
import service.interfaces.Validatable;

import java.util.Comparator;
import java.util.List;

public class AccountService implements Validatable<AccountBase> {

    private final CrudRepository<AccountBase, Integer> repository;

    public AccountService(CrudRepository<AccountBase, Integer> repository) {
        this.repository = repository;
    }

    public void create(AccountBase a) {
        validate(a);
        repository.create(a);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public List<AccountBase> sortByBalance() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(AccountBase::getBalance))
                .toList();
    }

    public void validate(AccountBase a) {
        notNull(a);
        Validatable.positive(a.getBalance());
    }
}
