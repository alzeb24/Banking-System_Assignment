package task9;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(int accountNumber, String customerName, double balance, double interestRate) {
        super(accountNumber, customerName, balance);
        this.interestRate = interestRate;
    }

    // Implement deposit method
    @Override
    public void deposit(float amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    // Implement withdraw method with error handling
    @Override
    public void withdraw(float amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Implement calculateInterest method
    @Override
    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added: " + interest + ", New Balance: " + balance);
    }

    // Getter and Setter for interestRate
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}

