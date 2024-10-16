package task11_12.bean;

public class CurrentAccount extends Account {
    private float overdraftLimit;

    public CurrentAccount(Customer customer, float initialBalance, float overdraftLimit) {
        super(customer, "Current", initialBalance);
        this.overdraftLimit = overdraftLimit;
    }
    
    public float getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public String getAccountType() {
        return "Current";
    }

    @Override
    public float withdraw(float amount) {
        if (balance - amount < -overdraftLimit) {
            System.out.println("Withdrawal exceeds overdraft limit.");
            return balance;
        }
        return super.withdraw(amount);
    }
}

