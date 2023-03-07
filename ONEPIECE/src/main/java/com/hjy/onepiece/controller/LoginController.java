package com.hjy.onepiece.controller;

import com.hjy.onepiece.entity.User;

import com.hjy.onepiece.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    @GetMapping("/getOne/{id}")
    public User getOne(@PathVariable String id){
        User byId = userService.findById(id);
        System.out.println("00000000----------"+byId);
        return byId;
    }

}
