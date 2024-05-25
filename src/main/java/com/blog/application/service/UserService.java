package com.blog.application.service;

import com.blog.application.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
   UserDto createUser(UserDto userDto);
   UserDto updateUser(UserDto user,long userid);
   UserDto getUserById(long userid);
   List<UserDto> getAllUsers();

   void deleteUser(long id);

}
