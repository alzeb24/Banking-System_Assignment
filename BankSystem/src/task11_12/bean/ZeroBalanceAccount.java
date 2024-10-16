package task11_12.bean;

public class ZeroBalanceAccount extends Account {
    public ZeroBalanceAccount(Customer customer) {
        super(customer, "Zero Balance", 0);
    }
}

