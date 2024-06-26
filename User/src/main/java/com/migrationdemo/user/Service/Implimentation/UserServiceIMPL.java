package com.migrationdemo.user.Service.Implimentation;

import com.migrationdemo.user.DTOs.UserEntityDto;
import com.migrationdemo.user.Entity.UserEntity;
import com.migrationdemo.user.Mapper.UserMapper;
import com.migrationdemo.user.Repository.UserRepository;
import com.migrationdemo.user.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceIMPL implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntityDto createUser(UserEntityDto userDTO) {
        UserEntity userEntity = userMapper.toEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        return userMapper.toDto(userEntity);
    }

    @Override
    public UserEntityDto updateUser(UserEntityDto userDTO) {
        UserEntity userEntity = userRepository.findById(userDTO.getId()).orElse(null);
        if (userEntity != null) {
            userEntity = userMapper.partialUpdate(userDTO, userEntity);
            userEntity = userRepository.save(userEntity);
            return userMapper.toDto(userEntity);
        }
        return null;
    }

    @Override
    public UserEntityDto getUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            return userMapper.toDto(userEntity);
        }
        return null;
    }

    @Override
    public UserEntityDto IncreaseNumberOfAccounts(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            userEntity.setAccountsNumber(userEntity.getAccountsNumber() + 1);
            userEntity = userRepository.save(userEntity);
            return userMapper.toDto(userEntity);
        }
        return null;
    }

    @Override
    public UserEntityDto DecreaseNumberOfAccounts(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            userEntity.setAccountsNumber(userEntity.getAccountsNumber() - 1);
            userEntity = userRepository.save(userEntity);
            return userMapper.toDto(userEntity);
        }
        return null;
    }

    @Override
    public UserEntityDto getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            return userMapper.toDto(userEntity);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserEntityDto> getAllUsers() {
        List<UserEntity> userEntity = userRepository.findAll();
        return userEntity.stream().map(userMapper::toDto).collect(Collectors.toList());
    }

}
