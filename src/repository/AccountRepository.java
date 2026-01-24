package repository;

import model.AccountBase;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    public void create(AccountBase account) {
        String sql = "INSERT INTO accounts(account_number, balance, type, customer_id) VALUES (?, ?, ?, ?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {

            s.setString(1, account.getAccountNumber());
            s.setDouble(2, account.getBalance());
            s.setString(3, account.getAccountType());
            s.setInt(4, account.getCustomer().getId());
            s.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getAll() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT * FROM accounts";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement(sql);
             ResultSet r = s.executeQuery()) {

            while (r.next()) {
                list.add(r.getString("account_number") + " " + r.getDouble("balance"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void delete(int id) {
        String sql = "DELETE FROM accounts WHERE id = ?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {

            s.setInt(1, id);
            s.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
