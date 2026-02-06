import controller.BankController;
import repository.AccountRepository;
import service.AccountService;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) throws Exception {

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/assik3",
                "postgres",
                "4865"
        );

        AccountRepository repository = new AccountRepository(connection);
        AccountService service = new AccountService(repository);
        BankController controller = new BankController(service);

        controller.start();
    }
}
