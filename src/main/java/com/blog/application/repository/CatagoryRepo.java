package com.blog.application.repository;

import com.blog.application.entity.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepo extends JpaRepository<Catagory,Long> {
}
