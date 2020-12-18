package com.raczkowski.springintro.service;

import com.raczkowski.springintro.dto.CredentialsDto;
import com.raczkowski.springintro.dto.UserDto;
import com.raczkowski.springintro.entity.User;
import com.raczkowski.springintro.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public UserService(PasswordEncoder passwordEncoder,
                       UserRepository userRepository,
                       AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    public void register(UserDto userDto) {
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    public void login(CredentialsDto credentialsDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentialsDto.getUsername(),
                credentialsDto.getPassword()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username %s cannot be found.", username)));
    }
}
