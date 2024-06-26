package com.migrationdemo.user.DTOs;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.migrationdemo.user.Entity.UserEntity}
 */
@Value
public class UserEntityDto implements Serializable {
    Long id;
    String username;
    String email;
    String password;
    LocalDate createdDate;
    int accountsNumber;

}