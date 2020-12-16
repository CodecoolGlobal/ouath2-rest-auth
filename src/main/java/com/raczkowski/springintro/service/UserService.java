package com.raczkowski.springintro.service;

import com.raczkowski.springintro.dto.UserDto;
import com.raczkowski.springintro.entity.User;
import com.raczkowski.springintro.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder,
                       UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void registerNewUser(UserDto userDto) {
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    public void login() {

    }
}
