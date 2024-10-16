package task8;

public class Account {
    private int accountId;
    private String accountType;
    protected double balance;  // Protected so that subclasses can access it

    // Default Constructor
    public Account() {
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

    // Overloaded deposit methods
    public void deposit(float amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    // Overloaded withdraw methods
    public void withdraw(float amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to calculate interest (for savings accounts)
    public void calculateInterest() {
        System.out.println("Interest is only applicable for savings accounts.");
    }

    // Print account details
    public void printAccountDetails() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }
}

