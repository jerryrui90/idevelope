package com.idevelope.imy.service.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService
{
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException
    {
        boolean enabled = true;
        Set<GrantedAuthority> grantedAuths =  new HashSet<GrantedAuthority>();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails =
            new org.springframework.security.core.userdetails.User(username, "123456", enabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
        return userDetails;
    }
}