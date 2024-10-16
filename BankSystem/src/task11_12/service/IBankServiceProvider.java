package task11_12.service;

import task11_12.bean.Account;
import task11_12.bean.Customer;

public interface IBankServiceProvider extends ICustomerServiceProvider {
    void create_account(Customer customer, String accType, float balance);
    Account[] listAccounts();
    float calculateInterest(long account_number);
}

