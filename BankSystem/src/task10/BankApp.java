package task10;

import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank(); // Create an instance of Bank
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Get Account Balance");
            System.out.println("6. Get Account Details");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create Account
                    System.out.println("--- Create Account ---");
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.next();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.next();
                    System.out.print("Enter Email Address: ");
                    String email = scanner.next();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.next();
                    System.out.print("Enter Address: ");
                    scanner.nextLine(); // Consume newline
                    String address = scanner.nextLine();
                    Customer customer = new Customer(customerId, firstName, lastName, email, phone, address);

                    System.out.print("Enter Account Type (Savings/Current): ");
                    String accountType = scanner.next();
                    System.out.print("Enter Initial Balance: ");
                    float initialBalance = scanner.nextFloat();

                    bank.create_account(customer, accountType, initialBalance);
                    break;

                case 2:
                    // Deposit
                    System.out.println("--- Deposit ---");
                    System.out.print("Enter Account Number: ");
                    long accountNumberDeposit = scanner.nextLong();
                    System.out.print("Enter Amount to Deposit: ");
                    float depositAmount = scanner.nextFloat();
                    float updatedBalance = bank.deposit(accountNumberDeposit, depositAmount);
                    System.out.println("New Balance: " + updatedBalance);
                    break;

                case 3:
                    // Withdraw
                    System.out.println("--- Withdraw ---");
                    System.out.print("Enter Account Number: ");
                    long accountNumberWithdraw = scanner.nextLong();
                    System.out.print("Enter Amount to Withdraw: ");
                    float withdrawAmount = scanner.nextFloat();
                    float remainingBalance = bank.withdraw(accountNumberWithdraw, withdrawAmount);
                    System.out.println("Remaining Balance: " + remainingBalance);
                    break;

                case 4:
                    // Transfer
                    System.out.println("--- Transfer ---");
                    System.out.print("Enter From Account Number: ");
                    long fromAccountNumber = scanner.nextLong();
                    System.out.print("Enter To Account Number: ");
                    long toAccountNumber = scanner.nextLong();
                    System.out.print("Enter Amount to Transfer: ");
                    float transferAmount = scanner.nextFloat();
                    bank.transfer(fromAccountNumber, toAccountNumber, transferAmount);
                    break;

                case 5:
                    // Get Account Balance
                    System.out.println("--- Get Account Balance ---");
                    System.out.print("Enter Account Number: ");
                    long accountNumberBalance = scanner.nextLong();
                    float balance = bank.get_account_balance(accountNumberBalance);
                    System.out.println("Account Balance: " + balance);
                    break;

                case 6:
                    // Get Account Details
                    System.out.println("--- Get Account Details ---");
                    System.out.print("Enter Account Number: ");
                    long accountNumberDetails = scanner.nextLong();
                    bank.getAccountDetails(accountNumberDetails);
                    break;

                case 7:
                    // Exit
                    exit = true;
                    System.out.println("Exiting the Banking System.");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }
}
