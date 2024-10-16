package task14.bean;

import java.util.Date;

public class Transaction {
    private Account account;
    private String description;
    private Date transactionDate;
    private String transactionType; // Withdraw, Deposit, Transfer
    private double transactionAmount;

    // Constructor
    public Transaction(Account account, String description, Date transactionDate, String transactionType, double transactionAmount) {
        this.account = account;
        this.description = description;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    // Getters and Setters
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "account=" + account +
                ", description='" + description + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionType='" + transactionType + '\'' +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}

