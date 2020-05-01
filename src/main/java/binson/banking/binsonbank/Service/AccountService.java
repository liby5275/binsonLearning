package binson.banking.binsonbank.Service;

import binson.banking.binsonbank.Request.CreateAccountRequest;
import binson.banking.binsonbank.aggregate.AccountDetailsAggregate;

import java.util.List;

public interface AccountService {
    public String accountSave(CreateAccountRequest createAccountRequest);
    public String getCustomerName(int accountNumber);
    public String updateUserName(CreateAccountRequest createAccountRequest);
    public String deleteUserData(CreateAccountRequest createAccountRequest);
    public List<AccountDetailsAggregate> getAccountsList();
}
