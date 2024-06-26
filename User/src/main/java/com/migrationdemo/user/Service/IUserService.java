package com.migrationdemo.user.Service;

import com.migrationdemo.user.DTOs.UserEntityDto;

import java.util.List;

public interface IUserService {
    UserEntityDto createUser(UserEntityDto userDTO);

    UserEntityDto updateUser(UserEntityDto userDTO);

    UserEntityDto getUserByUsername(String username);

    UserEntityDto IncreaseNumberOfAccounts(Long id);

    UserEntityDto DecreaseNumberOfAccounts(Long id);

    UserEntityDto getUserById(Long id);

    void deleteUser(Long id);

    List<UserEntityDto> getAllUsers();
}
