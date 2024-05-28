package com.blog.application.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "catagory" )
public class Catagory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "catogory_name")
    private String catagoryName;

    @Column(name = "catogory_desc")
    private String catagoryDescription;

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    @OneToMany(mappedBy = "catagory",cascade = CascadeType.ALL)
    private List<Post> post = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public String getCatagoryDescription() {
        return catagoryDescription;
    }

    public void setCatagoryDescription(String catagoryDescription) {
        this.catagoryDescription = catagoryDescription;
    }
}
