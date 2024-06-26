package com.migrationdemo.adapter;

import com.migrationdemo.feignclient.AccountClient;
import com.migrationdemo.feignclient.AccountEntityDto;
import com.migrationdemo.feignclient.UserClient;
import com.migrationdemo.feignclient.UserEntityDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Slf4j
@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private UserClient userClient;

    public AccountEntityDto createAccount(Long userId, String accountNumber, Float balance) {

        log.info("creating account for user with id: " + userId);
        UserEntityDto user = userClient.getUsers(userId);
        if (user == null) {
            throw new RuntimeException("User with id " + userId + " does not exist");
        }

        // If the user exists, create the account
        return accountClient.createAccount(userId, accountNumber, balance);
    }
}