package com.blog.application.service;

import com.blog.application.dto.PostDto;
import com.blog.application.entity.Post;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto,long userId,long catagoryId);

    PostDto updatePost(PostDto postDto,long id);

    PostDto getPostById(long id);

    List<PostDto> getAllPost();

    void deletePost(long id);

    List<PostDto> getPostByUser(long userId);

    List<PostDto> getPostByCatagory(long catagoryId);

    List<PostDto> searchPost(String keyWord);



}
