package com.blog.application.controller;

import com.blog.application.dto.CommentDto;
import com.blog.application.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/postComment/{postId}")
    public ResponseEntity<CommentDto> postComment(@RequestBody CommentDto commentDto, @PathVariable long postId){
        CommentDto commentDto1 = commentService.postComment(commentDto,postId);
        return  new ResponseEntity<>(commentDto1, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteComment/{commentId}")
    public void deletePost(@PathVariable long commentId){
        commentService.deleteComment(commentId);
    }
}
