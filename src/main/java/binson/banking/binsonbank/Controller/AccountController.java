package binson.banking.binsonbank.Controller;

import binson.banking.binsonbank.Request.CreateAccountRequest;
import binson.banking.binsonbank.Service.AccountService;
import binson.banking.binsonbank.aggregate.AccountDetailsAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/account/data", method = RequestMethod.POST)
    public String saveAccountDetails(@RequestBody CreateAccountRequest createAccountRequest) {
      String result =  accountService.accountSave(createAccountRequest);
      return result;

    }

    @RequestMapping(value = "/account/data/name/{accountNumber}", method = RequestMethod.GET)
    public String getCustmerName(@PathVariable int accountNumber) {

        return accountService.getCustomerName(accountNumber);

    }

    @RequestMapping(value = "/account/data/update/name",method = RequestMethod.PUT)
    public String updatCustomerName(@RequestBody CreateAccountRequest createAccountRequest){
       String message =  accountService.updateUserName(createAccountRequest);
        return message;
    }

    @RequestMapping(value = "/account/data/delete",method = RequestMethod.PUT)
    public String deleteUserData(@RequestBody CreateAccountRequest createAccountRequest){
       String message = accountService.deleteUserData(createAccountRequest);
       return message;

    }

    @RequestMapping(value = "/account/list",method = RequestMethod.GET)
    public List<AccountDetailsAggregate> getAccountsList(){
        return accountService.getAccountsList();
    }
}
