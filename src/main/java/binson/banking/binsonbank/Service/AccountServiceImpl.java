package binson.banking.binsonbank.Service;

import binson.banking.binsonbank.RepoService.AccountRepoService;
import binson.banking.binsonbank.Request.CreateAccountRequest;
import binson.banking.binsonbank.aggregate.AccountDetailsAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    String message = "";


    @Autowired
    private AccountRepoService accountRepoService;

    public String accountSave(CreateAccountRequest createAccountRequest) {

        int result = accountRepoService.saveAccountDetails(createAccountRequest);
        if(result<1){
            message = "this account does not exist ";
        }
        else
        {
            message ="successfully updated ";
        }
        return  message;

    }

    @Override
    public AccountDetailsAggregate getCustomerName(int accountNumber) {
        AccountDetailsAggregate accountDetailsAggregate = accountRepoService.getCustmerDetails(accountNumber);
       return  accountDetailsAggregate;
    }

    @Override
    public String updateUserName(CreateAccountRequest createAccountRequest) {
        int accId = createAccountRequest.getAccountNumber();
        String updatedName = createAccountRequest.getFname();
        int deletedResult= accountRepoService.updateUserName(accId, updatedName);
        if(deletedResult<1){
            message = "this account does not exist ";
        }
        else
        {
            message ="successfully updated ";
        }
        return  message;

    }

    @Override
    public String deleteUserData(CreateAccountRequest createAccountRequest) {
        int accntNumber = createAccountRequest.getAccountNumber();
       int deletedResult= accountRepoService.deleteUserData(accntNumber);

        if(deletedResult<1){
            message = "this account does not exist ";
        }
        else
        {
            message ="successfully deleted ";
        }
        return  message;
    }

    @Override
    public List<AccountDetailsAggregate> getAccountsList() {

        return accountRepoService.getAccountsList();

    }

    @Override
    public List<AccountDetailsAggregate> getDeletedAccountList() {
        return  accountRepoService.getDeletedAccountList();
    }
}
