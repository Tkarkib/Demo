package com.migrationdemo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-client", url = "http://localhost:5050")
public interface UserClient {

    @GetMapping("/api/v1/user/getUsers/{userId}")
    UserEntityDto getUsers(@PathVariable Long userId);

    @GetMapping("/api/v1/user/getUsers")
    List<UserEntityDto> getUsers();

    @DeleteMapping("/api/v1/user/deleteUser/{userId}")
    void deleteUser(@PathVariable Long userId);

    @PutMapping("/api/v1/user/updateUser")
    UserEntityDto updateUser(@RequestBody UserEntityDto userDTO);

    @PostMapping("/api/v1/user/createUser")
    UserEntityDto createUser(@RequestBody UserEntityDto userDTO);

    @PutMapping("/api/v1/user/increaseNumberOfAccounts/{userId}")
    UserEntityDto increaseNumberOfAccounts(@PathVariable Long userId);

    @PutMapping("/api/v1/user/decreaseNumberOfAccounts/{userId}")
    UserEntityDto decreaseNumberOfAccounts(@PathVariable Long userId);

    @GetMapping("/api/v1/user/getUserByUsername/{username}")
    UserEntityDto getUserByUsername(@PathVariable String username);

}