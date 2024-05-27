package com.blog.application.serviceImpl;

import com.blog.application.dto.PostDto;
import com.blog.application.entity.Catagory;
import com.blog.application.entity.Post;
import com.blog.application.entity.User;
import com.blog.application.exception.ResourceNotFoundException;
import com.blog.application.repository.CatagoryRepo;
import com.blog.application.repository.PostRepo;
import com.blog.application.repository.UserRepository;
import com.blog.application.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
   @Autowired
    private PostRepo postRepo;

   @Autowired
    private UserRepository userRepository;

   @Autowired
    private CatagoryRepo catagoryRepo;

   @Autowired
   private ModelMapper modelMapper;



    @Override
    public PostDto createPost(PostDto postDto,long userId,long catagoryId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","userId",userId));
        Catagory catagory = catagoryRepo.findById(catagoryId).orElseThrow(()-> new ResourceNotFoundException("catagory","catagoryId",catagoryId));

        Post post = modelMapper.map(postDto,Post.class);
        post.setImageName("image.png");
        post.setDate(new Date());
        post.setUser(user);
        post.setCatagory(catagory);
        Post savePost = postRepo.save(post);
        return modelMapper.map(savePost,PostDto.class)
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("post","id",id));
        post.setDate(new Date());
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setImageName(postDto.getImageName());
        postRepo.save(post);
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public PostDto getPostById(long id) {
        Post findPost = postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("findPost","id",id));
        return modelMapper.map(findPost,PostDto.class);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> allPosts = postRepo.findAll();
        List<PostDto> allPostdto = allPosts.stream()
                .map(posts -> modelMapper.map(posts,PostDto.class)).collect(Collectors.toList());
        return allPostdto;
    }

    @Override
    public void deletePost(long id) {
     Post post = postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("post","id",id));
     postRepo.delete(post);
    }

    @Override
    public List<PostDto> getPostByUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","userId",userId));
        List<Post> postByUser = postRepo.findByUser(user);
        List<PostDto> postByUserDto = postByUser.stream().
                map(post -> modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postByUserDto;
    }

    @Override
    public List<PostDto> getPostByCatagory(long catagoryId) {
        Catagory catagory = catagoryRepo.findById(catagoryId).orElseThrow(()-> new ResourceNotFoundException("catagory","catagoryId",catagoryId));
        List<Post> postByCatagory = postRepo.findByCatagory(catagory);
        List<PostDto> postByCatagoryDto = postByCatagory.stream().
                map(catagoryMap-> modelMapper.map(catagoryMap,PostDto.class)).collect(Collectors.toList());
        return postByCatagoryDto;
    }

    @Override
    public List<PostDto> searchPost(String keyWord) {
        return null;
    }
}
