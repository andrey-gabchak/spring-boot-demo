package com.gabchak.springbootdemo.service;

import com.gabchak.springbootdemo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(this::toUserDetails)
                .orElseGet(() -> User.builder().disabled(true).build());
    }

    private UserDetails toUserDetails(com.gabchak.springbootdemo.model.User user) {
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
