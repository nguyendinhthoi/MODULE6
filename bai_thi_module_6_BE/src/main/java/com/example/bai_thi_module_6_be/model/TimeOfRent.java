package com.example.bai_thi_module_6_be.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeOfRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTimeOfRent;
    private String nameTimeOfRent;
    private double priceOfRent;

}
