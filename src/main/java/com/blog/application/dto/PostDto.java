package com.blog.application.dto;
import com.blog.application.entity.Catagory;
import com.blog.application.entity.Comment;
import com.blog.application.entity.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PostDto {

    private String title;
    private String content;

    private String imageName;
    private Date date;

    private UserDto user;

    private CatagoryDto catagory;

    private Set<Comment> comments = new HashSet<>();

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public CatagoryDto getCatagory() {
        return catagory;
    }

    public void setCatagory(CatagoryDto catagory) {
        this.catagory = catagory;
    }
}
