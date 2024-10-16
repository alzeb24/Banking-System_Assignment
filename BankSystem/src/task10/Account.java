package task10;

public class Account {
    private long accountNumber;
    private String accountType;
    private float accountBalance;
    private Customer customer;

    // Static variable for auto-incrementing account numbers
    private static long nextAccountNumber = 1001;

    // Default constructor
    public Account() {}

    // Parameterized constructor
    public Account(Customer customer, String accountType, float accountBalance) {
        this.accountNumber = nextAccountNumber++;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customer = customer;
    }

    // Getters and setters
    public long getAccountNumber() { 
    	return accountNumber; 
    	}

    public String getAccountType() { 
    	return accountType; 
    	}
    public void setAccountType(String accountType) { 
    	this.accountType = accountType; 
    	}

    public float getAccountBalance() { 
    	return accountBalance; 
    	}
    public void setAccountBalance(float accountBalance) { 
    	this.accountBalance = accountBalance; 
    	}

    public Customer getCustomer() { 
    	return customer; 
    	}
    public void setCustomer(Customer customer) { 
    	this.customer = customer; 
    	}

    public void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + accountBalance);
        customer.printDetails();
    }
}

