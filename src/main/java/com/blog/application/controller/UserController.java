package com.blog.application.controller;

import com.blog.application.dto.UserDto;
import com.blog.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
       UserDto registeredUser = userService.createUser(userDto);
       return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user,@PathVariable long userId){
        UserDto userDto = userService.updateUser(user,userId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{findUser}")
    public ResponseEntity<?> findUser(@PathVariable long findUser){
        UserDto user = userService.getUserById(findUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable long userId){
        userService.deleteUser(userId);
      }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return  ResponseEntity.ok(userService.getAllUsers());
    }


}
