package com.migrationdemo.feignclient;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
public class UserEntityDto implements Serializable {
    Long id;
    String name;
    String email;
    String password;
    LocalDate createdDate;
    int accountsNumber;

}