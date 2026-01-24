import controller.BankController;
import model.*;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(1, "Batyrkhan", "batyr@gmail.com");

        AccountBase savings = new SavingsAccount(1, "SA-001", 1000, customer);
        AccountBase checking = new CheckingAccount(2, "CA-001", 500, customer);

        BankController controller = new BankController();

        controller.create(savings);
        controller.create(checking);

        savings.deposit(200);
        checking.withdraw(100);

        controller.showAll();

        controller.delete(1);
    }
}

