package task11_12.bean;

public class Account {
    private static long lastAccNo = 1000; // static variable to hold last account number
    protected long accountNumber;
    protected String accountType;
    protected float balance;
    protected Customer customer;

    public Account(Customer customer, String accountType, float initialBalance) {
        this.accountNumber = ++lastAccNo; // auto-generate account number
        this.accountType = accountType;
        this.balance = initialBalance;
        this.customer = customer;
    }

    // Getters and Setters
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public float getBalance() {
        return balance;
    }

    public void deposit(float amount) {
        this.balance += amount;
    }

    public float withdraw(float amount) {
        this.balance -= amount;
        return this.balance;
    }

    public Customer getCustomer() {
        return customer;
    }
}

