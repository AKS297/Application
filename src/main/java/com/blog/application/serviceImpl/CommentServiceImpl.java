package com.blog.application.serviceImpl;

import com.blog.application.dto.CommentDto;
import com.blog.application.entity.Comment;
import com.blog.application.entity.Post;
import com.blog.application.repository.CommentRepo;
import com.blog.application.repository.PostRepo;
import com.blog.application.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto postComment(CommentDto commentDto, long postId) {
        Post post = postRepo.findById(postId).orElseThrow();
        Comment addcomment = modelMapper.map(commentDto,Comment.class);
        addcomment.setPost(post);
        commentRepo.save(addcomment);
        return modelMapper.map(addcomment,CommentDto.class);
    }
}
