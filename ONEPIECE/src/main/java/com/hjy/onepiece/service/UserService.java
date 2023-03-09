package com.hjy.onepiece.service;

import com.hjy.onepiece.entity.User;
import com.hjy.onepiece.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findById(String id){

        return userRepository.getById(Long.parseLong(id));
    }
    public User getByName(String username){
        return userRepository.getByName(username);
    }

    public User save(User user){
        User save = userRepository.save(user);
        return save;
    }
}
