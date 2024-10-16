package task14.app;

import task14.bean.Account;
import task14.bean.Customer;
import task14.bean.Transaction;
import task14.exception.InvalidAccountException;
import task14.service.BankServiceProviderImpl;
import task14.service.CustomerServiceProviderImpl;
import task14.service.ICustomerServiceProvider;
import task14.service.IBankServiceProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) throws InvalidAccountException {
        Scanner scanner = new Scanner(System.in);
        IBankServiceProvider bankServiceProvider = new BankServiceProviderImpl();
        ICustomerServiceProvider customerServiceProvider = new CustomerServiceProviderImpl();

        while (true) {
            System.out.println("Welcome to the Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Get Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Get Account Details");
            System.out.println("7. List Accounts");
            System.out.println("8. Get Transactions");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
                // Create Account
                while (true) {
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt(); // Read customer ID

                    System.out.print("Enter first name: ");
                    String firstName = scanner.next(); // Read first name

                    System.out.print("Enter last name: ");
                    String lastName = scanner.next(); // Read last name
                    
                    System.out.print("Enter date of birth (dd-MM-yyyy): ");
                    String dobString = scanner.next(); // Read date of birth as a string

                    // Parse the date of birth string to a Date object
                    Date dob = null;
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        dob = sdf.parse(dobString);
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please enter the date in dd-MM-yyyy format.");
                        continue; // Prompt again
                    }

                    System.out.print("Enter email: ");
                    String email = scanner.next(); // Read email

                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.next(); // Read phone number

                    System.out.print("Enter address: ");
                    String address = scanner.next(); // Read address

                    // Create the Customer object with the provided details
                    Customer customer = new Customer(customerId, firstName, lastName, dob, email, phoneNumber, address);

                    System.out.print("Enter account number: ");
                    long accNo = scanner.nextLong();

                    System.out.print("Choose account type (1. Savings, 2. Current, 3. Zero Balance): ");
                    int accTypeChoice = scanner.nextInt();
                    String accType;

                    switch (accTypeChoice) {
                        case 1:
                            accType = "savings";
                            break;
                        case 2:
                            accType = "current";
                            break;
                        case 3:
                            accType = "zerobalance";
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            continue;
                    }

                    System.out.print("Enter initial balance: ");
                    float balance = scanner.nextFloat();

                    // Call the service to create the account
                    bankServiceProvider.createAccount(customer, accNo, accType, balance);
                    System.out.println("Account created successfully.");

                    System.out.print("Do you want to create another account? (yes/no): ");
                    String repeat = scanner.next().toLowerCase();
                    if (!repeat.equals("yes")) {
                        break; // Exit the account creation loop
                    }
                }
                break;

                case 2:
                    // Deposit
                    System.out.print("Enter account number: ");
                    long depositAccNo = scanner.nextLong();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankServiceProvider.deposit(depositAccNo, depositAmount);
                    System.out.println("Deposit successful.");
                    break;

                case 3:
                    // Withdraw
                    System.out.print("Enter account number: ");
                    long withdrawAccNo = scanner.nextLong();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankServiceProvider.withdraw(withdrawAccNo, withdrawAmount);
                    System.out.println("Withdrawal successful.");
                    break;

                case 4:
                    // Get Balance
                    System.out.print("Enter account number: ");
                    long balanceAccNo = scanner.nextLong();
                    double accountBalance = bankServiceProvider.getBalance(balanceAccNo);
                    System.out.println("Account balance: " + accountBalance);
                    break;

                case 5:
                    // Transfer
                    System.out.print("Enter source account number: ");
                    long fromAccNo = scanner.nextLong();
                    System.out.print("Enter destination account number: ");
                    long toAccNo = scanner.nextLong();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    bankServiceProvider.transfer(fromAccNo, toAccNo, transferAmount);
                    System.out.println("Transfer successful.");
                    break;

                case 6:
                    // Get Account Details
                    System.out.print("Enter account number: ");
                    long accountDetailsAccNo = scanner.nextLong();
                    Account accountDetails = bankServiceProvider.getAccountDetails(accountDetailsAccNo);
                    System.out.println("Account Details: " + accountDetails);
                    break;

                case 7:
                    // List Accounts
                    List<Account> accountsList = bankServiceProvider.listAccounts();
                    System.out.println("Accounts List:");
                    for (Account acc : accountsList) {
                        System.out.println(acc);
                    }
                    break;

                case 8:
                    // Get Transactions
                    System.out.print("Enter account number: ");
                    long transactionAccNo = scanner.nextLong();
                    System.out.print("Enter from date (yyyy-mm-dd): ");
                    String fromDateStr = scanner.next();
                    System.out.print("Enter to date (yyyy-mm-dd): ");
                    String toDateStr = scanner.next();
                    Date fromDate = java.sql.Date.valueOf(fromDateStr);
                    Date toDate = java.sql.Date.valueOf(toDateStr);
                    List<Transaction> transactions = bankServiceProvider.getTransactions(transactionAccNo, fromDate, toDate);
                    System.out.println("Transactions:");
                    for (Transaction trans : transactions) {
                        System.out.println(trans);
                    }
                    break;

                case 9:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

