package com.example.bai_thi_module_6_be.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FootballFieldType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFootballFieldType;
    private String nameFootballFieldType;
}
