package com.blog.application.security;

import com.blog.application.entity.User;
import com.blog.application.exception.ResourceNotFoundException;
import com.blog.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.ResourceAccessException;

import java.nio.file.ReadOnlyFileSystemException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user=  userRepository.findByUserName(username).orElseThrow(()-> new ResourceAccessException("Resource Not Found"));

        return null;
    }
}
