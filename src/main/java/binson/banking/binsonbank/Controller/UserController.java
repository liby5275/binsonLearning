package binson.banking.binsonbank.Controller;

import binson.banking.binsonbank.Request.CreateUserRequest;
import binson.banking.binsonbank.Response.ResponseMessage;
import binson.banking.binsonbank.Service.UserService;
import binson.banking.binsonbank.aggregate.UserDetailsAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ResponseMessage userDataSave(@RequestBody CreateUserRequest createUserRequest) {
        ResponseMessage responseMessage = userService.userDataSave(createUserRequest);
        return responseMessage;
    }

    @RequestMapping(value = "/user/details/{accountNumber}", method = RequestMethod.GET)
    public UserDetailsAggregate getUserDetails(@PathVariable int accountNumber) {
        UserDetailsAggregate userDetailsAggregate = userService.getUserDetails(accountNumber);
        return userDetailsAggregate;

    }

    @RequestMapping(value = "/user/password/change", method = RequestMethod.PUT)
    public ResponseMessage changePswd(@RequestBody CreateUserRequest createUserRequest) {
        ResponseMessage responseMessage = userService.changePswd(createUserRequest);
        return responseMessage;


    }
}
