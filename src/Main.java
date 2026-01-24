import controller.BankController;
import model.*;

public class Main {
    public static void main(String[] args) {
        Customer c = new Customer(1, "Batyrkhan", "batyr@gmail.com");

        AccountBase a1 = new SavingsAccount(1, "SA-001", 1000, c);
        AccountBase a2 = new CheckingAccount(2, "CA-001", 500, c);

        BankController bc = new BankController();

        bc.create(a1);
        bc.create(a2);

        a1.deposit(200);
        a2.withdraw(100);

        bc.showAll();
        bc.delete(1);
    }
}

