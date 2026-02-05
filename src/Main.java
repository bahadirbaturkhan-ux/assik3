import controller.BankController;
import model.*;
import repository.AccountRepository;
import service.AccountService;
import utils.ReflectionUtils;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(1, "Batyrkhan", "b@gmail.com");
        AccountBase account = new SavingsAccount(1, "SA-100", 1000, customer);

        AccountService service = new AccountService(new AccountRepository());
        BankController controller = new BankController(service);

        controller.create(account);
        ReflectionUtils.inspect(account);
    }
}
