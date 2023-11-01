package com.example.bai_thi_module_6_be.controller;

import com.example.bai_thi_module_6_be.dto.IDistrictDto;
import com.example.bai_thi_module_6_be.dto.IFootballFieldDto;
import com.example.bai_thi_module_6_be.dto.ITimeDto;
import com.example.bai_thi_module_6_be.dto.ITypeDto;
import com.example.bai_thi_module_6_be.model.District;
import com.example.bai_thi_module_6_be.model.FootballField;
import com.example.bai_thi_module_6_be.model.FootballFieldType;
import com.example.bai_thi_module_6_be.service.IFootballFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class FootballFieldController {
    @Autowired
    private IFootballFieldService footballFieldService;
//    @GetMapping("/list")
//    public ResponseEntity<Page<IFootballFieldDto>> getAllFootballField(
//            @RequestParam(value = "page",required = false,defaultValue = "0") int page,
//            @RequestParam(value = "choose",required = false,defaultValue = "name") String choose,
//            @RequestParam(value = "value",required = false,defaultValue = "") String value){
//        Page<IFootballFieldDto> footballFieldDtos;
//        Pageable pageable = PageRequest.of(page,5);
//        switch (choose){
//            case "name":
//            footballFieldDtos = footballFieldService.getAllByName(pageable,value);
//            break;
//            case "district":
//                if (Objects.equals(value, "")) {
//                    footballFieldDtos = footballFieldService.getAllByName(pageable, "");
//                    break;
//                }
//                footballFieldDtos = footballFieldService.getAllByDistrict(pageable, value);
//                break;
//            case "type":
//                if (Objects.equals(value, "")) {
//                    footballFieldDtos = footballFieldService.getAllByName(pageable, "");
//                    break;
//                }
//                footballFieldDtos = footballFieldService.getALlByType(pageable, value);
//                break;
//            default:
//                footballFieldDtos = footballFieldService.getAllByName(pageable,"");
//        }
//            return new ResponseEntity<>(footballFieldDtos, HttpStatus.OK) ;
//    }
    @GetMapping("/list")
    public ResponseEntity<Page<IFootballFieldDto>> getAllFootballField(
            @RequestParam(value = "page",required = false,defaultValue = "0") int page,
            @RequestParam(value = "searchName",defaultValue = "",required = false) String searchName){
        Pageable pageable = PageRequest.of(page,10);
        Page<IFootballFieldDto> footballFieldDtos = footballFieldService.getAllByName(pageable,searchName);
        return new ResponseEntity<>(footballFieldDtos,HttpStatus.OK);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteField(@PathVariable int id){
        footballFieldService.deleteField(id);
        return new ResponseEntity<>("delete ok",HttpStatus.OK);
    }
    @GetMapping("/type")
    public ResponseEntity<List<ITypeDto>> getAllType(){
        List<ITypeDto> footballFieldTypes = footballFieldService.getAllType();
        return new ResponseEntity<>(footballFieldTypes,HttpStatus.OK);
    }
    @GetMapping("/district")
    public ResponseEntity<List<IDistrictDto>> getAllDistrict(){
        List<IDistrictDto> districts = footballFieldService.getAllDistrict();
        return new ResponseEntity<>(districts,HttpStatus.OK);
    }
    @GetMapping("/time")
    public ResponseEntity<List<ITimeDto>> getAllTime(){
        List<ITimeDto> timeDtos = footballFieldService.getAllTime();
        return new ResponseEntity<>(timeDtos,HttpStatus.OK);
    }
}
