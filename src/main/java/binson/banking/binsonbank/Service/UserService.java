package binson.banking.binsonbank.Service;

import binson.banking.binsonbank.Request.CreateUserRequest;
import binson.banking.binsonbank.aggregate.UserDetailsAggregate;

public interface UserService {
    public String userDataSave(CreateUserRequest createUserRequest);
    public UserDetailsAggregate getUserDetails( int accountNumber);
    public String changePswd ( CreateUserRequest createUserRequest);
}
