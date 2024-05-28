package com.blog.application.controller;


import com.blog.application.dto.PostDto;
import com.blog.application.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long postId){
        PostDto postById = postService.getPostById(postId);
        return ResponseEntity.ok(postById);
    }

    @GetMapping("/post/allPosts")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPost());
    }

    @DeleteMapping("/post/deletePost/{postId}")
    public void deletePost(@PathVariable long postId) {
        postService.deletePost(postId);
    }

    @GetMapping("/post/userPosts/{userId}")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable long userId){
        List<PostDto> allUserPosts = postService.getPostByUser(userId);
        return ResponseEntity.ok(allUserPosts);
    }

    @GetMapping("/post/catagoryPosts/{catagoryId}")
    public ResponseEntity<List<PostDto>> getPostsByCatagory(@PathVariable long catagoryId){
        List<PostDto> allCatagoryPosts = postService.getPostByCatagory(catagoryId);
        return ResponseEntity.ok(allCatagoryPosts);
    }
}
