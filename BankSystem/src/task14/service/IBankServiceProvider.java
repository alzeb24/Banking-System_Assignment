package task14.service;

import task14.bean.Account;
import task14.bean.Customer;
import task14.bean.Transaction;
import task14.exception.InvalidAccountException;

import java.util.Date;
import java.util.List;


public interface IBankServiceProvider {
	void createAccount(Customer customer, long accNo, String accType, float balance);
	
    void deposit(long accountNumber, double amount) throws InvalidAccountException;
    
    void withdraw(long accountNumber, double amount) throws InvalidAccountException;
    
    double getBalance(long accountNumber) throws InvalidAccountException;
    
    void transfer(long fromAccount, long toAccount, double amount) throws InvalidAccountException;
    
    List<Account> listAccounts();
    
    List<Transaction> getTransactions(long accountId, Date fromDate, Date toDate) throws InvalidAccountException;
    
    Account getAccountDetails(long accountNumber) throws InvalidAccountException;
    
    double calculateInterest(long accountNumber) throws InvalidAccountException;

}


