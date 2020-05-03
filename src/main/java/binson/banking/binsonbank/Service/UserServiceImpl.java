package binson.banking.binsonbank.Service;

import binson.banking.binsonbank.RepoService.UserRepoService;
import binson.banking.binsonbank.Request.CreateUserRequest;
import binson.banking.binsonbank.Response.ResponseMessage;
import binson.banking.binsonbank.aggregate.UserDetailsAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.java2d.pipe.SpanShapeRenderer;

@Service
public class UserServiceImpl implements  UserService{

    ResponseMessage responseMessage = new ResponseMessage();
    String message="";
    @Autowired
    private UserRepoService userRepoService;

    @Override
    public ResponseMessage userDataSave(CreateUserRequest createUserRequest) {
       int rowCount= userRepoService.userDataSave(createUserRequest);

        if(rowCount<1){
            responseMessage.setResponseMessage("something went wrong");

        }
        else{
            responseMessage.setResponseMessage("something went wrong");

        }
        return  responseMessage;
    }

    @Override
    public UserDetailsAggregate getUserDetails(int accountNumber) {
    UserDetailsAggregate userDetailsAggregate=  userRepoService.getUserDetails(accountNumber);
    return userDetailsAggregate;
    }

    @Override
    public ResponseMessage changePswd(CreateUserRequest createUserRequest) {
        int accountNumber = createUserRequest.getAccountNumber();
        String password = createUserRequest.getPassword();

        int rowCount= userRepoService.changePswd(accountNumber, password);
        if(rowCount<1){


            responseMessage.setResponseMessage("something went wrong");
        }
        else{
            responseMessage.setResponseMessage(" password updated successfully");

        }
        return  responseMessage;
    }



}
