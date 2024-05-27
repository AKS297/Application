package com.blog.application.repository;

import com.blog.application.entity.Catagory;
import com.blog.application.entity.Post;
import com.blog.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByUser(User user);
    List<Post> findByCatagory(Catagory catagory);
}
