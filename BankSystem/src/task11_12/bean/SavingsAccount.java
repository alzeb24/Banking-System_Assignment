package task11_12.bean;

public class SavingsAccount extends Account {
    private float interestRate;

    public SavingsAccount(Customer customer, float initialBalance, float interestRate) {
        super(customer, "Savings", initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public float withdraw(float amount) {
        if (balance - amount < 500) {
            System.out.println("Insufficient funds. Minimum balance of 500 must be maintained.");
            return balance;
        }
        return super.withdraw(amount);
    }

    public float calculateInterest() {
        return balance * interestRate / 100;
    }
}

