package task7;

public class Bank {
    public static void main(String[] args) {
        // Creating a new Account object with parameterized constructor
        Account account = new Account(101, "Savings", 1000);

        // Deposit amount
        account.deposit(500);

        // Withdraw amount
        account.withdraw(300);

        // Calculate interest for Savings Account
        account.calculateInterest();

        // Print account details
        account.printAccountDetails();
    }
}

