package task11_12.service;

import task11_12.bean.Account;
import task11_12.bean.Customer;

public class BankServiceProviderImpl extends CustomerServiceProviderImpl implements IBankServiceProvider {
    private String branchName;
    private String branchAddress;

    public BankServiceProviderImpl(String branchName, String branchAddress) {
        this.branchName = branchName;
        this.branchAddress = branchAddress;
    }

    @Override
    public void create_account(Customer customer, String accType, float balance) {
        Account account = null;

        switch (accType) {
            case "Savings":
                account = new task11_12.bean.SavingsAccount(customer, balance, 4.0f); // Example interest rate
                break;
            case "Current":
                account = new task11_12.bean.CurrentAccount(customer, balance, 1000); // Example overdraft limit
                break;
            case "Zero Balance":
                account = new task11_12.bean.ZeroBalanceAccount(customer);
                break;
            default:
                System.out.println("Invalid account type.");
                return;
        }

        addAccount(account);
        System.out.println("Account created successfully. Account Number: " + account.getAccountNumber());
    }

    @Override
    public Account[] listAccounts() {
        return accounts;
    }

    @Override
    public float calculateInterest(long account_number) {
        for (Account account : accounts) {
            if (account != null && account.getAccountNumber() == account_number) {
                if (account instanceof task11_12.bean.SavingsAccount) {
                    return ((task11_12.bean.SavingsAccount) account).calculateInterest();
                }
            }
        }
        System.out.println("Account number not found or is not a savings account.");
        return 0;
    }
}

