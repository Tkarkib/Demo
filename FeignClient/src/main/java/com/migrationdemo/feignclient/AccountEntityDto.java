package com.migrationdemo.feignclient;

import lombok.Data;

import java.io.Serializable;



@Data
public class AccountEntityDto implements Serializable {
    Long id;
    String accountNumber;
    double balance;
    Long UserId;

}