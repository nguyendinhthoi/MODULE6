package com.example.bai_thi_module_6_be.service;

import com.example.bai_thi_module_6_be.dto.IDistrictDto;
import com.example.bai_thi_module_6_be.dto.IFootballFieldDto;
import com.example.bai_thi_module_6_be.dto.ITimeDto;
import com.example.bai_thi_module_6_be.dto.ITypeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFootballFieldService {
    Page<IFootballFieldDto> getAllByName(Pageable pageable, String value);

//    Page<IFootballFieldDto> getAllByDistrict(Pageable pageable, String value);
//
//    Page<IFootballFieldDto> getALlByType(Pageable pageable, String value);

    List<ITypeDto> getAllType();

    List<IDistrictDto> getAllDistrict();

    void deleteField(int id);

    List<ITimeDto> getAllTime();
}
