package com.blog.application.serviceImpl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.blog.application.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class JwtAuthenticationService {
    @Value("${jwt.algorythm.key}")
    private String algorythmkey;

    //who is going to issue the token
    @Value("${jwt.token.issuer}")
    private String tokenIssuer;

    @Value("${jwt.time.seconds}")
    private int expiryInSeconds;

    private Algorithm algorithm;

    private static final String USERNAME_KEY = "USERNAME";

    @PostConstruct
    public void postConstruct(){
        algorithm = Algorithm.HMAC256(algorythmkey);
    }

    public String generateJwtToken(User user){
        return JWT
                .create()
                .withClaim(USERNAME_KEY,user.getUserName())
                .withExpiresAt(new Date(System.currentTimeMillis() +(1000 * expiryInSeconds)))
                .withIssuer(tokenIssuer)
                .sign(algorithm);
    }

    public String getUsername(String token){
        return JWT.decode(token).getClaim(USERNAME_KEY).asString();
    }

}
