package com.raczkowski.springintro.authenticationprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * To use custom authentication provider you need to register it in:
 * <code>authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider)</code>
 */

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

//    private UserDetailsService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (isValid(username, password)) {
            return new UsernamePasswordAuthenticationToken(username, password, Collections.singletonList(new SimpleGrantedAuthority("USER")));
        }

        throw new BadCredentialsException("Couldn't authenticate with username: " + username + " and password: " + password);
    }

    private boolean isValid(String username, String password) {
//        UserDetails userDetails = userService.loadUserByUsername(username);

//        return userDetails.getPassword().equals(password);
        return false;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
