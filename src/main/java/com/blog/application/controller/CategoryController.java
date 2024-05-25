package com.blog.application.controller;


import com.blog.application.dto.CatagoryDto;
import com.blog.application.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catagory")
public class CategoryController {

    @Autowired
    private CatagoryService catagoryService;

    @PostMapping("/create")
    public ResponseEntity<CatagoryDto> createCatagory(@RequestBody CatagoryDto catagoryDto){
      CatagoryDto createCatagory =  catagoryService.createCatagory(catagoryDto);
      return new ResponseEntity<>(createCatagory, HttpStatus.CREATED);
    }

   @PutMapping("/upadet/{categoryId}")
    public ResponseEntity<CatagoryDto> updateCatagory(@RequestBody CatagoryDto catagoryDto,@PathVariable long categoryId){
        CatagoryDto catagoryUpdate = catagoryService.updateCatagory(catagoryDto,categoryId);
        return ResponseEntity.ok(catagoryUpdate);
    }

    @GetMapping("/getCatagory/{catagoryId}")
    public ResponseEntity<CatagoryDto> getCatagoryById(@PathVariable long catagoryId){
        CatagoryDto catagoryDto = catagoryService.findCatagoryById(catagoryId);
        return ResponseEntity.ok(catagoryDto);
    }

    @GetMapping("/getAllCatagories")
    public ResponseEntity<List<CatagoryDto>> getAllCatagories(){
        List<CatagoryDto> catagoryDto = catagoryService.getAllCatagory();
        return ResponseEntity.ok(catagoryDto);
    }

    @DeleteMapping("/deleteCatagory/{catagoryId}")
    public void deleteCatagory(@PathVariable long catagoryId){
        catagoryService.deleteCatagory(catagoryId);
    }


}
