package com.project.shopapp.configurations;

import com.project.shopapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserRepository userRepository;
    // user detail object
    public UserDetailsService userDetailsService() {
        return phoneNumber -> {
            return userRepository
                    .findByPhoneNumber(phoneNumber)
                    .orElseThrow(() -> new UsernameNotFoundException("Not found user with phone number"));
        }
    }
}
