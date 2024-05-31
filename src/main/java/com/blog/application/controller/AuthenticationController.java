package com.blog.application.controller;


import com.blog.application.dto.LogInDto;
import com.blog.application.dto.LogInResponse;
import com.blog.application.service.UserService;
import com.blog.application.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @PostMapping("/logIn")
    public ResponseEntity<LogInResponse> loginUser(@RequestBody LogInDto logInDto){
      String jwt =  userService.logInUser(logInDto);
      if(jwt == null){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
      }else{
          LogInResponse log = new LogInResponse();
          log.setJwt(jwt);
          return ResponseEntity.ok(log);
      }

    }

}
