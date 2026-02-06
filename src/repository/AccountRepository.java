package repository;

import model.AccountBase;
import model.SavingsAccount;
import model.CheckingAccount;
import repository.interfaces.CrudRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements CrudRepository<AccountBase> {

    private final Connection connection;

    public AccountRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(AccountBase account, int customerId) {
        String sql = """
                INSERT INTO accounts (account_number, balance, customer_id, type)
                VALUES (?, ?, ?, ?)
                """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, account.getAccountNumber());
            stmt.setDouble(2, account.getBalance());
            stmt.setInt(3, customerId);
            stmt.setString(4, account.getAccountType());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error creating account", e);
        }
    }

    @Override
    public List<AccountBase> findAll() {
        List<AccountBase> accounts = new ArrayList<>();

        String sql = "SELECT * FROM accounts";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String type = rs.getString("type");

                AccountBase account;

                if ("SAVINGS".equalsIgnoreCase(type)) {
                    account = new SavingsAccount(
                            rs.getInt("id"),
                            rs.getString("account_number"),
                            rs.getDouble("balance")
                    );
                } else {
                    account = new CheckingAccount(
                            rs.getInt("id"),
                            rs.getString("account_number"),
                            rs.getDouble("balance")
                    );
                }

                accounts.add(account);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error reading accounts", e);
        }

        return accounts;
    }
}


