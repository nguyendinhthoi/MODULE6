package com.example.bai_thi_module_6_be.service;

import com.example.bai_thi_module_6_be.dto.IDistrictDto;
import com.example.bai_thi_module_6_be.dto.IFootballFieldDto;
import com.example.bai_thi_module_6_be.dto.ITimeDto;
import com.example.bai_thi_module_6_be.dto.ITypeDto;
import com.example.bai_thi_module_6_be.repository.IFootballFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballFieldService implements IFootballFieldService{
    @Autowired
    private IFootballFieldRepository footballFieldRepository;




//    @Override
//    public Page<IFootballFieldDto> getAllByDistrict(Pageable pageable, String value) {
//        return footballFieldRepository.getAllByDistrict(pageable,Integer.parseInt(value));
//    }
//
//    @Override
//    public Page<IFootballFieldDto> getALlByType(Pageable pageable, String value) {
//        return footballFieldRepository.getAllByType(pageable,Integer.parseInt(value));
//    }

    @Override
    public Page<IFootballFieldDto> getAllByName(Pageable pageable, String value) {
        return footballFieldRepository.getAllByName(pageable,"%"+value+"%");
    }

    @Override
    public List<ITypeDto> getAllType() {
        return footballFieldRepository.getAllType();
    }

    @Override
    public List<IDistrictDto> getAllDistrict() {
        return footballFieldRepository.getAllDistrict();
    }

    @Override
    public void deleteField(int id) {
        footballFieldRepository.deleteField(id);
    }

    @Override
    public List<ITimeDto> getAllTime() {
        return footballFieldRepository.getAllTime();
    }
}
