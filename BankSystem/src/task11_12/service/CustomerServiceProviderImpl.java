package task11_12.service;

import task11_12.bean.Account;
import task11_12.exception.InsufficientFundException;
import task11_12.exception.InvalidAccountException;
import task11_12.exception.OverDraftLimitExceededException;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider {
    protected Account[] accounts = new Account[100]; // Max 100 accounts
    protected int accountCount = 0;

    @Override
    public float getAccountBalance(long account_number) throws InvalidAccountException {
        Account account = findAccount(account_number);
        if (account == null) {
            throw new InvalidAccountException("Account number " + account_number + " not found.");
        }
        return account.getBalance();
    }

    @Override
    public float deposit(long account_number, float amount) throws InvalidAccountException {
        Account account = findAccount(account_number);
        if (account == null) {
            throw new InvalidAccountException("Account number " + account_number + " not found.");
        }
        account.deposit(amount);
        return account.getBalance();
    }

    @Override
    public float withdraw(long account_number, float amount) throws InsufficientFundException, InvalidAccountException, OverDraftLimitExceededException {
        Account account = findAccount(account_number);
        if (account == null) {
            throw new InvalidAccountException("Account number " + account_number + " not found.");
        }
        if (account instanceof task11_12.bean.CurrentAccount) {
            task11_12.bean.CurrentAccount currentAccount = (task11_12.bean.CurrentAccount) account;
            if (amount > currentAccount.getBalance() + currentAccount.getOverdraftLimit()) {
                throw new OverDraftLimitExceededException("Overdraft limit exceeded.");
            }
        } else if (account.getBalance() < amount) {
            throw new InsufficientFundException("Insufficient funds for withdrawal.");
        }
        return account.withdraw(amount);
    }

    @Override
    public void transfer(long from_account_number, long to_account_number, float amount) throws InsufficientFundException, InvalidAccountException, OverDraftLimitExceededException {
        Account fromAccount = findAccount(from_account_number);
        Account toAccount = findAccount(to_account_number);

        if (fromAccount == null || toAccount == null) {
            throw new InvalidAccountException("One or both account numbers are invalid.");
        }

        float withdrawnAmount = withdraw(from_account_number, amount); // Use withdraw method to handle exceptions
        toAccount.deposit(amount);
        System.out.println("Transferred " + amount + " from account " + from_account_number + " to account " + to_account_number);
    }

    @Override
    public void getAccountDetails(long account_number) throws InvalidAccountException {
        Account account = findAccount(account_number);
        if (account == null) {
            throw new InvalidAccountException("Account number " + account_number + " not found.");
        }
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Customer: " + account.getCustomer().getFirstName() + " " + account.getCustomer().getLastName());
    }

    private Account findAccount(long account_number) {
        for (Account account : accounts) {
            if (account != null && account.getAccountNumber() == account_number) {
                return account;
            }
        }
        return null;
    }

    public void addAccount(Account account) {
        if (accountCount < accounts.length) {
            accounts[accountCount++] = account;
        } else {
            System.out.println("Cannot add more accounts.");
        }
    }
}
