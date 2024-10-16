package task7;

public class Account {
    private int accountId;
    private String accountType;
    private double balance;

    // Default Constructor
    public Account() {
        // Initialize default values (if needed)
    }

    // Parameterized Constructor
    public Account(int accountId, String accountType, double balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getters and Setters
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to deposit amount
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    // Method to withdraw amount
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to calculate interest (fixed at 4.5%)
    public void calculateInterest() {
        if (accountType.equalsIgnoreCase("Savings")) {
            double interest = balance * 0.045;
            balance += interest;
            System.out.println("Interest Added: " + interest + ", New Balance: " + balance);
        } else {
            System.out.println("Interest calculation is only available for savings accounts.");
        }
    }

    // Method to print all account details
    public void printAccountDetails() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }
}

