package com.migrationdemo.user.Consumer;

import com.migrationdemo.feignclient.AccountEntityDto;
import com.migrationdemo.user.Service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserConsumer {

    @Autowired
    IUserService userService;


    @KafkaListener(topics = "Userchanger", groupId = "Communication", containerFactory = "kafkaListenerContainerFactory")
    public void consume(AccountEntityDto account) {
        log.info("increasing account number ");
        userService.IncreaseNumberOfAccounts(account.getUserId());
    }

}
