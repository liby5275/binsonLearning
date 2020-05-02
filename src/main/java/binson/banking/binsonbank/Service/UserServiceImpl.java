package binson.banking.binsonbank.Service;

import binson.banking.binsonbank.RepoService.UserRepoService;
import binson.banking.binsonbank.Request.CreateUserRequest;
import binson.banking.binsonbank.aggregate.UserDetailsAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.java2d.pipe.SpanShapeRenderer;

@Service
public class UserServiceImpl implements  UserService{
    String message="";
    @Autowired
    private UserRepoService userRepoService;

    @Override
    public String userDataSave(CreateUserRequest createUserRequest) {
       int rowCount= userRepoService.userDataSave(createUserRequest);
        if(rowCount<1){
            message="something went wrong";
        }
        else{
            message = "updated successfully";
        }
        return  message;
    }

    @Override
    public UserDetailsAggregate getUserDetails(int accountNumber) {
    UserDetailsAggregate userDetailsAggregate=  userRepoService.getUserDetails(accountNumber);
    return userDetailsAggregate;
    }

    @Override
    public String changePswd(CreateUserRequest createUserRequest) {
        int accountNumber = createUserRequest.getAccountNumber();
        String password = createUserRequest.getPassword();
        int rowCount= userRepoService.changePswd(accountNumber, password);
        if(rowCount<1){
            message="something went wrong";
        }
        else{
            message = "password updated successfully";
        }
        return  message;
    }



}
