package task9;

public class CurrentAccount extends BankAccount {
    private final double overdraftLimit = 5000;  // Fixed overdraft limit

    // Constructor
    public CurrentAccount(int accountNumber, String customerName, double balance) {
        super(accountNumber, customerName, balance);
    }

    // Implement deposit method
    @Override
    public void deposit(float amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    // Implement withdraw method with overdraft limit
    @Override
    public void withdraw(float amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Withdrawal denied. Exceeds overdraft limit.");
        }
    }

    // Current accounts have no interest, so this method does nothing
    @Override
    public void calculateInterest() {
        System.out.println("No interest for current accounts.");
    }
}

