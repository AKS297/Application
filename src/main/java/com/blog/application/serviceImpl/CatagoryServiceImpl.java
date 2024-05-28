package com.blog.application.serviceImpl;

import com.blog.application.dto.CatagoryDto;
import com.blog.application.entity.Catagory;
import com.blog.application.exception.ResourceNotFoundException;
import com.blog.application.repository.CatagoryRepo;
import com.blog.application.service.CatagoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatagoryServiceImpl implements CatagoryService {

    @Autowired
    private CatagoryRepo catagoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CatagoryDto createCatagory(CatagoryDto catagoryDto) {
        Catagory catagory = modelMapper.map(catagoryDto,Catagory.class);
        catagoryRepo.save(catagory);
        return modelMapper.map(catagory,CatagoryDto.class);
    }

    @Override
    public CatagoryDto updateCatagory(CatagoryDto catagoryDto, long id) {
       Catagory findCatagory = catagoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("catagoryTofind","id",id));
            findCatagory.setCatagoryName(catagoryDto.getCatagoryName());
            findCatagory.setCatagoryDescription(catagoryDto.getCatagoryDescription());
            catagoryRepo.save(findCatagory);
       return modelMapper.map(findCatagory,CatagoryDto.class);
    }

    @Override
    public CatagoryDto findCatagoryById(long id) {
        Catagory findcatagory = catagoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("findcatagory","id",id));
        return modelMapper.map(findcatagory,CatagoryDto.class);
    }

    @Override
    public List<CatagoryDto> getAllCatagory() {
       List<Catagory> allCatagories = catagoryRepo.findAll();
      List<CatagoryDto> catagoryDto = allCatagories.stream()
              .map(catagory -> modelMapper.map(allCatagories,CatagoryDto.class)).collect(Collectors.toList());
        return catagoryDto;
    }

    @Override
    public void deleteCatagory(long id) {
     Catagory catagory = catagoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("catagory","id",id));
     catagoryRepo.delete(catagory);
    }
}
