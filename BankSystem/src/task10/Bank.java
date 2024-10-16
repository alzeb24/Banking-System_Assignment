package task10;

public class Bank {
    private Account[] accounts;  // Array to store accounts
    private int accountCount;     // Number of accounts created
    private static final int MAX_ACCOUNTS = 100;  // Maximum number of accounts

    public Bank() {
        accounts = new Account[MAX_ACCOUNTS];  // Initialize the array with a maximum size
        accountCount = 0;  // Initialize account count to zero
    }

    // Create a new account
    public void create_account(Customer customer, String accountType, float balance) {
        if (accountCount < MAX_ACCOUNTS) {
            Account newAccount = new Account(customer, accountType, balance);
            accounts[accountCount] = newAccount;  // Add account to the array
            accountCount++;  // Increment account count
            System.out.println("Account created successfully with Account Number: " + newAccount.getAccountNumber());
        } else {
            System.out.println("Cannot create more accounts, the bank is full.");
        }
    }

    // Retrieve account balance by account number
    public float get_account_balance(long accountNumber) {
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            return account.getAccountBalance();
        } else {
            System.out.println("Account not found");
            return 0;
        }
    }

    // Deposit money into an account
    public float deposit(long accountNumber, float amount) {
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            account.setAccountBalance(account.getAccountBalance() + amount);
            return account.getAccountBalance();
        } else {
            System.out.println("Account not found");
            return 0;
        }
    }

    // Withdraw money from an account
    public float withdraw(long accountNumber, float amount) {
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            if (account.getAccountBalance() >= amount) {
                account.setAccountBalance(account.getAccountBalance() - amount);
                return account.getAccountBalance();
            } else {
                System.out.println("Insufficient balance.");
                return account.getAccountBalance();
            }
        } else {
            System.out.println("Account not found");
            return 0;
        }
    }

    // Transfer money between two accounts
    public void transfer(long fromAccountNumber, long toAccountNumber, float amount) {
        Account fromAccount = findAccountByNumber(fromAccountNumber);
        Account toAccount = findAccountByNumber(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getAccountBalance() >= amount) {
                fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);
                toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    // Print account and customer details
    public void getAccountDetails(long accountNumber) {
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            account.printDetails();
        } else {
            System.out.println("Account not found");
        }
    }

    // Helper method to find an account by account number
    private Account findAccountByNumber(long accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;  // Return null if the account is not found
    }
}
