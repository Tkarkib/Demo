package com.migrationdemo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "account-client", url = "http://localhost:6060")
public interface AccountClient {

    @GetMapping("/accounts")
    Iterable<AccountEntityDto> getAccounts();

    @PostMapping("/createAccount")
    AccountEntityDto createAccount(@RequestParam("userId") long userId,
                                   @RequestParam("accountNumber") String accountNumber,
                                   @RequestParam("balance") Float balance);
}