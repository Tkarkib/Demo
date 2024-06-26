package com.migrationdemo.authentication.User;

import com.migrationdemo.feignclient.UserEntityDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

public class RemoteUserDetailsService implements UserDetailsService {

    private final RestTemplate restTemplate;

    public RemoteUserDetailsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Make a request to the User service to get the user data
        //TODO change FROM REST TEMPLATE TO FEIGN CLIENT
        UserEntityDto user = restTemplate.getForObject("http://user-service/api/v1/user/getUsers/" + username, UserEntityDto.class);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new RemoteUserDetails(user);
    }
}