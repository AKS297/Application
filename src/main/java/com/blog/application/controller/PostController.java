package com.blog.application.controller;


import com.blog.application.dto.PostDto;
import com.blog.application.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/catagory/{catagoryId}")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable long userId,@PathVariable long catagoryId){
       PostDto createPost = postService.createPost(postDto,userId,catagoryId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }
}
