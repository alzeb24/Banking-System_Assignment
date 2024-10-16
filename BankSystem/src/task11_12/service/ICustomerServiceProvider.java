package task11_12.service;

import task11_12.bean.Account;
import task11_12.exception.InsufficientFundException;
import task11_12.exception.InvalidAccountException;
import task11_12.exception.OverDraftLimitExceededException;

public interface ICustomerServiceProvider {
    float getAccountBalance(long account_number) throws InvalidAccountException;
    float deposit(long account_number, float amount) throws InvalidAccountException;
    float withdraw(long account_number, float amount) throws InsufficientFundException, InvalidAccountException, OverDraftLimitExceededException;
    void transfer(long from_account_number, long to_account_number, float amount) throws InsufficientFundException, InvalidAccountException, OverDraftLimitExceededException;
    void getAccountDetails(long account_number) throws InvalidAccountException;
}

