package com.blog.application.service;

import com.blog.application.dto.CatagoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatagoryService {
    CatagoryDto createCatagory(CatagoryDto catagoryDto);
    CatagoryDto updateCatagory(CatagoryDto catagoryDto,long id);
    CatagoryDto findCatagoryById(long id);
    List<CatagoryDto> getAllCatagory();
    void deleteCatagory(long id);
}
