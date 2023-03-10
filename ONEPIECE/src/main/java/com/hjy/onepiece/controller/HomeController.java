package com.hjy.onepiece.controller;

import com.hjy.onepiece.entity.User;
import com.hjy.onepiece.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;
    @RequestMapping("/login")
    public String home(){
        return "/login";
    }
}
