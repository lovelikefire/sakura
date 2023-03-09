package com.hjy.onepiece.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService
{
    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.hjy.onepiece.entity.User user = userService.getByName(username);
        if (user==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return new User(user.getUsername(),user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("hejinayu")));
    }
}
