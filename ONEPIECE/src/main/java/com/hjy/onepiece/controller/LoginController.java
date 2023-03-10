package com.hjy.onepiece.controller;

import com.hjy.onepiece.dto.Result;
import com.hjy.onepiece.entity.User;

import com.hjy.onepiece.service.JwtService;
import com.hjy.onepiece.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;
    @GetMapping("/getOne/{id}")
    public User getOne(@PathVariable String id){
        User byId = userService.findById(id);
        System.out.println("00000000----------"+byId);
        return byId;
    }
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        System.out.println("username-------"+user.getUsername());
        System.out.println("password-------"+user.getPassword());
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        boolean authenticated = authenticate.isAuthenticated();
        if (authenticated){
            String token1 = jwtService.getToken(authenticate);
            return Result.succ(token1);
        }else {
            return Result.fail(user.getUsername());
        }
    }
}
