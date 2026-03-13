package com.technew.studiophotografy.entity.user.auth;

import com.technew.studiophotografy.repository.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserDetailsServiceImple implements UserDetailsService {

    private final UserRepository userRepository;
    UserDetailsServiceImple(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userRepository.findByUserEmail(userEmail)
                .map(AuthorizedUser::new)
                .orElseThrow(() -> new UsernameNotFoundException(userEmail));

    }
}
