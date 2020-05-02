package binson.banking.binsonbank.Controller;

import binson.banking.binsonbank.Request.CreateUserRequest;
import binson.banking.binsonbank.Service.UserService;
import binson.banking.binsonbank.aggregate.UserDetailsAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String userDataSave(@RequestBody CreateUserRequest createUserRequest) {
        String message = userService.userDataSave(createUserRequest);
        return message;
    }

    @RequestMapping(value = "/user/details/{accountNumber}", method = RequestMethod.GET)

    public UserDetailsAggregate getUserDetails(@PathVariable int accountNumber) {
        UserDetailsAggregate userDetailsAggregate = userService.getUserDetails(accountNumber);
        return userDetailsAggregate;

    }

    @RequestMapping(value = "/user/password/change", method = RequestMethod.PUT)
    public String changePswd(@RequestBody CreateUserRequest createUserRequest) {
        String message = userService.changePswd(createUserRequest);
        return message;


    }
}
