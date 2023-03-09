package com.hjy.onepiece.filter;

import com.hjy.onepiece.dto.Result;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public Result checkPassword(Exception e){
        return Result.fail(400,"用户名或密码错误！",null);
    }
}
