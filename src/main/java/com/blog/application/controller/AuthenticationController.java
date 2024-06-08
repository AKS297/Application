package com.blog.application.controller;


import com.blog.application.dto.LogInDto;
import com.blog.application.dto.LogInResponse;
import com.blog.application.dto.UserDto;
import com.blog.application.entity.User;
import com.blog.application.service.UserService;
import com.blog.application.serviceImpl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

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

    @GetMapping("/loggedInUser")
     public UserDto getLoggedInUserDetails(@AuthenticationPrincipal User user){
        return modelMapper.map(user,UserDto.class);

     }


}
