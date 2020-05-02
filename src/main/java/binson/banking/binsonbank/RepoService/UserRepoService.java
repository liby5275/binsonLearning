package binson.banking.binsonbank.RepoService;

import binson.banking.binsonbank.Request.CreateUserRequest;
import binson.banking.binsonbank.aggregate.UserDetailsAggregate;

public interface UserRepoService {
    public int userDataSave(CreateUserRequest createUserRequest);
    public UserDetailsAggregate getUserDetails(int accountNumber);
    public int changePswd(int accountNumber,String password);
}
