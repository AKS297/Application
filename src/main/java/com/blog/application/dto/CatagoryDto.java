package com.blog.application.dto;

public class CatagoryDto {
    private long id;
    private String catagoryName;
    private String catagoryDescription;

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
