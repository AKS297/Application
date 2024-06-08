package com.blog.application.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.blog.application.entity.User;
import com.blog.application.repository.UserRepository;
import com.blog.application.serviceImpl.JwtAuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtAuthenticationService jwtAuthenticationService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader("Authorization");
        if(tokenHeader != null && tokenHeader.startsWith("Bearer")){
            String token = tokenHeader.substring(7);
            try{
                String userName = jwtAuthenticationService.getUsername(token);
                Optional<User> user = userRepository.findByUserName(userName);
                if(user.isPresent()){
                    User user1 =user.get();
                    UsernamePasswordAuthenticationToken authentication= new UsernamePasswordAuthenticationToken(user1,null,new ArrayList<>());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }catch (JWTDecodeException jwtDecodeException){

            }
        }
        filterChain.doFilter(request,response);
    }
}
