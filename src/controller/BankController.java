package controller;

import service.AccountService;

import java.util.Scanner;

public class BankController {

    private final AccountService service;
    private final Scanner scanner = new Scanner(System.in);

    public BankController(AccountService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
            System.out.println("""
                    1. New Checking Account
                    2. New Savings Account
                    3. Show All
                    4. Exit
                    """);

            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Account number: ");
                        String num = scanner.nextLine();

                        System.out.print("Balance: ");
                        double bal = Double.parseDouble(scanner.nextLine());

                        service.createAccount("checking", num, bal, 1);
                        System.out.println("Checking account created");
                    }
                    case 2 -> {
                        System.out.print("Account number: ");
                        String num = scanner.nextLine();

                        System.out.print("Balance: ");
                        double bal = Double.parseDouble(scanner.nextLine());

                        service.createAccount("savings", num, bal, 1);
                        System.out.println("Savings account created");
                    }
                    case 3 -> service.getAllAccounts().forEach(acc ->
                            System.out.println(
                                    acc.getAccountType() + " | " +
                                            acc.getAccountNumber() + " | " +
                                            acc.getBalance()
                            )
                    );
                    case 4 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}


