package task9;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        // Menu to select account type
        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = scanner.nextInt();

        // Create account based on user choice
        System.out.println("Enter Account Number:");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.println("Enter Customer Name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter Initial Balance:");
        double balance = scanner.nextDouble();

        switch (choice) {
            case 1:
                System.out.println("Enter Interest Rate:");
                double interestRate = scanner.nextDouble();
                account = new SavingsAccount(accountNumber, customerName, balance, interestRate);
                break;
            case 2:
                account = new CurrentAccount(accountNumber, customerName, balance);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Perform operations
        boolean running = true;
        while (running) {
            System.out.println("\nSelect Operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest (Only for Savings)");
            System.out.println("4. Show Account Details");
            System.out.println("5. Exit");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    float depositAmount = scanner.nextFloat();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdraw amount:");
                    float withdrawAmount = scanner.nextFloat();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.calculateInterest();
                    break;
                case 4:
                    account.printAccountDetails();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        }
        scanner.close();
    }
}

