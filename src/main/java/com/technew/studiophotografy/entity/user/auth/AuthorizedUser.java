package com.technew.studiophotografy.entity.user.auth;


import com.technew.studiophotografy.entity.user.Users;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class AuthorizedUser implements UserDetails {

    private final Users users;

    public AuthorizedUser(Users users) {
        this.users = users;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return users.getRoles()
                .stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getRole().name()))
                .collect(Collectors.toList());
    }

    @Override
    public @Nullable String getPassword() {
        return users.getUserPassword();
    }

    @Override
    public String getUsername() {
        return users.getUserEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
