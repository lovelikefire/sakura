package com.hjy.onepiece.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {


    public String getToken(Authentication auth){
        String token =null;
        Date date = new Date(System.currentTimeMillis()+1800000);//30分钟
        try {
            token= JWT.create()
                    .withIssuer("zxl")
                    .withExpiresAt(date)
                    .withClaim("username",auth.getName())
                    .sign(getAlgorithm());
        }catch (JWTCreationException e) {
           e.printStackTrace();
        }
        return token;
    }

    public boolean verified(String token){
        try {
            JWTVerifier jwtVerifier = JWT.require(this.getAlgorithm()).withIssuer("zxl").build();
            DecodedJWT verify = jwtVerifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
    private Algorithm getAlgorithm(){
        return Algorithm.HMAC256("secret");
    }
}
