package com.blog.application.repository;

import com.blog.application.dto.UserDto;
import com.blog.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   public Optional<User>  findByUserName(String name);
}
