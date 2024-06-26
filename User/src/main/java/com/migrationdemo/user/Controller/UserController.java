package com.migrationdemo.user.Controller;

import com.migrationdemo.user.DTOs.UserEntityDto;
import com.migrationdemo.user.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getUsers/{userId}")
    public ResponseEntity<UserEntityDto> getUsers(@PathVariable Long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/getUserByUsername/{username}")
    public ResponseEntity<UserEntityDto> getUserByUsername(@PathVariable String username){
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserEntityDto>> getUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserEntityDto> updateUser(@RequestBody UserEntityDto userDTO){
        return new ResponseEntity<>(userService.updateUser(userDTO), HttpStatus.OK);
    }

    @PutMapping("/increaseNumberOfAccounts/{userId}")
    public ResponseEntity<UserEntityDto> increaseNumberOfAccounts(@PathVariable Long userId){
        return new ResponseEntity<>(userService.IncreaseNumberOfAccounts(userId), HttpStatus.OK);
    }

    @PutMapping("/decreaseNumberOfAccounts/{userId}")
    public ResponseEntity<UserEntityDto> decreaseNumberOfAccounts(@PathVariable Long userId){
        return new ResponseEntity<>(userService.DecreaseNumberOfAccounts(userId), HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserEntityDto> createUser(@RequestBody UserEntityDto userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

}
