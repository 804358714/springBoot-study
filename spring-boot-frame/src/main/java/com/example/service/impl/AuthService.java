package com.example.service.impl;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthService implements UserDetailsService {

    @Resource
    AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findAccountByUsername(username);
        if (account == null){
            throw new UsernameNotFoundException("找不到用户");
        }
        return User
                .withUsername(account.getUsername())
                .password(account.getPassword())
                .roles("users")
                .build();
    }
}
