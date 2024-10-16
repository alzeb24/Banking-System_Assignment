package task8;

import task8.Account;

public class CurrentAccount extends Account {
    private final double overdraftLimit = 5000; // Fixed overdraft limit for current account

    // Constructor
    public CurrentAccount(int accountId, String accountType, double balance) {
        super(accountId, accountType, balance);
    }

    // Override the withdraw method to allow overdraft
    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Exceeds overdraft limit.");
        }
    }
}

