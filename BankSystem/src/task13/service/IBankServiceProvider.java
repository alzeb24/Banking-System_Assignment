package task13.service;

import task11_12.bean.Account;
import task11_12.bean.Customer;
import java.util.List;

public interface IBankServiceProvider extends ICustomerServiceProvider {
    void create_account(Customer customer, String accType, float balance);
    List<Account> listAccounts();
    float calculateInterest(long account_number);
    
}

