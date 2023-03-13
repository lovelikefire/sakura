package com.hjy.onepiece.controller;

import com.hjy.onepiece.dto.Result;
import com.hjy.onepiece.entity.User;
import com.hjy.onepiece.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("/head")
    public Result getHead(){
        System.out.println("--------------getHead");
        return Result.succ("嗨嗨嗨");
    }
}
