package com.example.bai_thi_module_6_be.repository;

import com.example.bai_thi_module_6_be.dto.IDistrictDto;
import com.example.bai_thi_module_6_be.dto.IFootballFieldDto;
import com.example.bai_thi_module_6_be.dto.ITimeDto;
import com.example.bai_thi_module_6_be.dto.ITypeDto;
import com.example.bai_thi_module_6_be.model.FootballField;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IFootballFieldRepository extends JpaRepository<FootballField,Integer> {
    @Query(value = "select f.id_football_field as idFootBallFieldDto, f.address_football_field as addressFootballFieldDto, " +
            "f.name_football_field as nameFootballFieldDto,  d.name_district as nameDistrictDto, " +
            "t.name_football_field_type as nameFootballFieldTypeDto, r.name_time_of_rent as timeOfRentDto " +
            "from football_field as f " +
            "join district as d " +
            "on f.id_district = d.id_district " +
            "join football_field_type as t " +
            "on f.id_football_field_type = t.id_football_field_type " +
            "join time_of_rent as r " +
            "on r.id_time_of_rent = f.id_time_of_rent " +
            "where name_football_field like :name",nativeQuery = true)
    Page<IFootballFieldDto> getAllByName(Pageable pageable,@Param("name") String s);
    @Query(value = "select f.id_football_field as idFootBallField, f.address_football_field as addressFootballField, " +
            "f.name_football_field as nameFootballField, d.name_district as nameDistict, " +
            "t.name_football_field_type as nameFootballFieldType, r.name_time_of_rent as nameTimeOfRent " +
            "from football_field as f " +
            "join district as d " +
            "on f.id_district = d.id_district " +
            "join football_field_type as t " +
            "on f.id_football_field_type = t.id_football_field_type " +
            "join time_of_rent as r " +
            "on r.id_time_of_rent = f.id_time_of_rent " +
            "where d.id_district = :id",nativeQuery = true)
    Page<IFootballFieldDto> getAllByDistrict(Pageable pageable,@Param("id") int value);
    @Query(value = "select f.id_football_field as idFootBallField, f.address_football_field as addressFootballField, " +
            "f.name_football_field as nameFootballField, d.name_district as nameDistict, " +
            "t.name_football_field_type as nameFootballFieldType, r.name_time_of_rent as nameTimeOfRent " +
            "from football_field as f " +
            "join district as d " +
            "on f.id_district = d.id_district " +
            "join football_field_type as t " +
            "on f.id_football_field_type = t.id_football_field_type " +
            "join time_of_rent as r " +
            "on r.id_time_of_rent = f.id_time_of_rent " +
            "where t.id_football_field_type = :id",nativeQuery = true)
    Page<IFootballFieldDto> getAllByType(Pageable pageable,@Param("id") int i);
    @Query(value = "select id_football_field_type as idType,name_football_field_type as nameType from football_field_type",nativeQuery = true)
    List<ITypeDto> getAllType();
    @Query(value = "select id_district as idDistrict, name_district as nameDistrict from district",nativeQuery = true)
    List<IDistrictDto> getAllDistrict();
    @Transactional
    @Modifying
    @Query(value = "delete from football_field where id_football_field = :id",nativeQuery = true)
    void deleteField(@Param("id")int id);
    @Query(value = "select id_time_of_rent as idTime, name_time_of_rent as name,price_of_rent as price from time_of_rent",nativeQuery = true)
    List<ITimeDto> getAllTime();
}
