package com.technew.studiophotografy.service;

import com.technew.studiophotografy.auth.AuthoredUser;
import com.technew.studiophotografy.repositorys.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImple implements UserDetailsService {

    private UserRepository userRepository;
    UserDetailsServiceImple(UserRepository userRepository) {
        userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userRepository.findByUserEmail(userEmail)
                .map(AuthoredUser::new)
                .orElseThrow(() -> new UsernameNotFoundException(userEmail));
    }
}
