package task8;

import java.util.Scanner;

import task8.Account;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;

        // Menu to select account type
        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = scanner.nextInt();

        // Create account based on user choice
        switch (choice) {
            case 1:
                account = new SavingsAccount(101, "Savings", 1000);
                System.out.println("Savings Account Created.");
                break;
            case 2:
                account = new CurrentAccount(102, "Current", 1000);
                System.out.println("Current Account Created.");
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Perform operations on the account
        System.out.println("Select Operation:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Calculate Interest");
        int operation = scanner.nextInt();

        switch (operation) {
            case 1:
                System.out.println("Enter deposit amount:");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 2:
                System.out.println("Enter withdraw amount:");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 3:
                if (account instanceof SavingsAccount) {
                    account.calculateInterest();
                } else {
                    System.out.println("Interest is not applicable for current accounts.");
                }
                break;
            default:
                System.out.println("Invalid operation.");
        }

        // Print account details
        account.printAccountDetails();
        scanner.close();
    }
}
