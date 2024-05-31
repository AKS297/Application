package com.blog.application.serviceImpl;

import com.blog.application.dto.LogInDto;
import com.blog.application.dto.UserDto;
import com.blog.application.entity.User;
import com.blog.application.exception.ResourceNotFoundException;
import com.blog.application.repository.UserRepository;
import com.blog.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private JwtAuthenticationService jwtService;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        user.setPassword(encryptionService.encryptPassword(userDto.getPassword()));
        User saveUser = userRepository.save(user);
        return this.UserToDto(saveUser);
    }

    @Override
    public String logInUser(LogInDto userDetails){
    Optional<User> user = userRepository.findByUserName(userDetails.getUserName());
    if(user.isPresent()){
        User user1 = user.get();
       if(encryptionService.verifyPassword(userDetails.getPassword(),user1.getPassword())){
         return jwtService.generateJwtToken(user1);
       }
      }
       return null;
    }

    @Override
    public UserDto updateUser(UserDto userdto, long userid) {
        User findUser = userRepository.findById(userid).orElseThrow(() -> new ResourceNotFoundException("User","Id",userid));
       findUser.setUserName(userdto.getUserName());
       findUser.setEmail(userdto.getEmail());
       findUser.setPassword(userdto.getPassword());
       findUser.setAbout(userdto.getAbout());

       userRepository.save(findUser);
        return this.UserToDto(findUser);
    }

    @Override
    public UserDto getUserById(long userid) {
        User findUserExist = userRepository.findById(userid).orElseThrow(() -> new ResourceNotFoundException("User","Id",userid));
        return this.UserToDto(findUserExist);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<UserDto> userDtoList =  allUsers.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public void deleteUser(long id) {
     User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
     userRepository.delete(user);
    }

    public User dtoToUser(UserDto dto){
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setAbout(dto.getAbout());
        return user;
    }

    public UserDto UserToDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setAbout(user.getAbout());
        return dto;
    }


}
