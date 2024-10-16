package task8;

import task8.Account;

public class SavingsAccount extends Account {
    private double interestRate = 4.5; // Fixed interest rate for savings account

    // Constructor
    public SavingsAccount(int accountId, String accountType, double balance) {
        super(accountId, accountType, balance);
    }

    // Override the calculateInterest() method
    @Override
    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added: " + interest + ", New Balance: " + balance);
    }
}

