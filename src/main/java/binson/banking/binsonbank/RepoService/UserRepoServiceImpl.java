package binson.banking.binsonbank.RepoService;

import binson.banking.binsonbank.Request.CreateUserRequest;
import binson.banking.binsonbank.aggregate.UserDetailsAggregate;
import binson.banking.binsonbank.factory.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource(value = {"classpath:query.properties"})
public class UserRepoServiceImpl implements UserRepoService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Value("${save.user.details}")
    public String userDataSave;

    @Value(("${get.user.details}"))
    public String getUSerDetails;

    @Value("${set.password}")
    public String updatedPswd;

    @Override
    public int userDataSave(CreateUserRequest createUserRequest) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("Name", createUserRequest.getName());
        mapSqlParameterSource.addValue("Email", createUserRequest.getEmail());
        mapSqlParameterSource.addValue("PhoneNumber", createUserRequest.getPhone());
        mapSqlParameterSource.addValue("AccountId", createUserRequest.getAccountNumber());
        mapSqlParameterSource.addValue("Country", createUserRequest.getCountry());
        mapSqlParameterSource.addValue("Password", createUserRequest.getPassword());

        System.out.println(createUserRequest.getEmail());
        int rowCount = jdbcTemplate.update(this.userDataSave, mapSqlParameterSource);
        return  rowCount;


    }

    @Override
    public UserDetailsAggregate getUserDetails(int accountNumber) {

        MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
        mapSqlParameterSource.addValue("accountNumber",accountNumber);
       UserDetailsAggregate userDetailsAggregate = jdbcTemplate.queryForObject
               (this.getUSerDetails,mapSqlParameterSource, UserRowMapper.FETCH_USER_DETAILS_MAPPER);
       return userDetailsAggregate;

    }

    @Override
    public int changePswd(int accountNumber,String password) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("accountNumber",accountNumber);
        mapSqlParameterSource.addValue("password",password);
        int rowCount = jdbcTemplate.update(this.updatedPswd,mapSqlParameterSource);
        return rowCount;
    }
}
