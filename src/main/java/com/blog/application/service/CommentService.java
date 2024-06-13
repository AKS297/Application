package com.blog.application.service;

import com.blog.application.dto.CommentDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    CommentDto postComment(CommentDto commentDto,long postId);

    void deleteComment(long id);
}
