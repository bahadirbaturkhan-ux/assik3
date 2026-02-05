package repository;

import model.AccountBase;
import repository.interfaces.CrudRepository;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository implements CrudRepository<AccountBase, Integer> {

    public void create(AccountBase a) {
        String sql = "INSERT INTO accounts(account_number,balance,type,customer_id) VALUES (?,?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {

            s.setString(1, a.getAccountNumber());
            s.setDouble(2, a.getBalance());
            s.setString(3, a.getAccountType());
            s.setInt(4, a.getCustomer().getId());
            s.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<AccountBase> findById(Integer id) {
        return Optional.empty();
    }

    public List<AccountBase> findAll() {
        return new ArrayList<>();
    }

    public void update(Integer id, AccountBase a) {}

    public void delete(Integer id) {
        String sql = "DELETE FROM accounts WHERE id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {

            s.setInt(1, id);
            s.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

