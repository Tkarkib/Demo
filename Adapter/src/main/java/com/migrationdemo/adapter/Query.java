//package com.migrationdemo.adapter;
//
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//import com.migrationdemo.feignclient.AccountClient;
//import com.migrationdemo.feignclient.UserClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Query implements GraphQLQueryResolver {
//
//    @Autowired
//    private AccountClient accountClient;
//
//    @Autowired
//    private UserClient userClient;
//
//    public List<Account> accounts() {
//        // Call the account service and transform the response
//    }
//
//    public List<User> users() {
//        // Call the user service and transform the response
//    }
//}
//
//
