package task11_12.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import task11_12.bean.Account;
import task11_12.bean.Customer;
import task11_12.exception.InsufficientFundException;
import task11_12.exception.InvalidAccountException;
import task11_12.exception.OverDraftLimitExceededException;
import task11_12.service.BankServiceProviderImpl;

public class BankApp {
    public static void main(String[] args) {
        BankServiceProviderImpl bankService = new BankServiceProviderImpl("Main Branch", "123 Bank St.");
        Scanner scanner = new Scanner(System.in);
        int choice;

        try {
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Get Balance");
                System.out.println("5. Transfer");
                System.out.println("6. Get Account Details");
                System.out.println("7. List Accounts");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1: // Create Account
                        System.out.print("Enter Customer ID: ");
                        int customerId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter First Name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Enter Initial Balance: ");
                        float balance = scanner.nextFloat();
                        System.out.print("Choose Account Type (Savings/Current/Zero Balance): ");
                        String accType = scanner.next();
                        Customer customer = new Customer(customerId, firstName, lastName, "", "", "");
                        bankService.create_account(customer, accType, balance);
                        break;

                    case 2: // Deposit
                        System.out.print("Enter Account Number: ");
                        long accNoDeposit = scanner.nextLong();
                        System.out.print("Enter Amount to Deposit: ");
                        float depositAmount = scanner.nextFloat();
                        float newBalanceAfterDeposit = bankService.deposit(accNoDeposit, depositAmount);
                        System.out.println("New Balance: " + newBalanceAfterDeposit);
                        break;

                    case 3: // Withdraw
                        System.out.print("Enter Account Number: ");
                        long accNoWithdraw = scanner.nextLong();
                        System.out.print("Enter Amount to Withdraw: ");
                        float withdrawAmount = scanner.nextFloat();
                        float newBalanceAfterWithdraw = bankService.withdraw(accNoWithdraw, withdrawAmount);
                        System.out.println("New Balance: " + newBalanceAfterWithdraw);
                        break;

                    case 4: // Get Balance
                        System.out.print("Enter Account Number: ");
                        long accNoBalance = scanner.nextLong();
                        float balanceAfterGet = bankService.getAccountBalance(accNoBalance);
                        System.out.println("Account Balance: " + balanceAfterGet);
                        break;

                    case 5: // Transfer
                        System.out.print("Enter From Account Number: ");
                        long fromAccNo = scanner.nextLong();
                        System.out.print("Enter To Account Number: ");
                        long toAccNo = scanner.nextLong();
                        System.out.print("Enter Amount to Transfer: ");
                        float transferAmount = scanner.nextFloat();
                        bankService.transfer(fromAccNo, toAccNo, transferAmount);
                        break;

                    case 6: // Get Account Details
                        System.out.print("Enter Account Number: ");
                        long accNoDetails = scanner.nextLong();
                        bankService.getAccountDetails(accNoDetails);
                        break;

                    case 7: // List Accounts
                        Account[] accounts = bankService.listAccounts();
                        for (Account acc : accounts) {
                            if (acc != null) {
                                System.out.println("Account Number: " + acc.getAccountNumber() + 
                                                   ", Balance: " + acc.getBalance() + 
                                                   ", Account Type: " + acc.getAccountType());
                            }
                        }
                        break;

                    case 8: // Exit
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            } while (choice != 8);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
        } catch (InvalidAccountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientFundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (OverDraftLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: Attempted to access a null reference.");
        } finally {
            scanner.close();
        }
    }
}
