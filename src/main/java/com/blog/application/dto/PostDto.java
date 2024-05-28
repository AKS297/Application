package com.blog.application.dto;
import com.blog.application.entity.Catagory;
import com.blog.application.entity.User;

import java.util.Date;

public class PostDto {

    private String title;
    private String content;

    private String imageName;
    private Date date;

    private UserDto user;

    private CatagoryDto catagory;


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
