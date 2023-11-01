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
public class FootballField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFootballField;
    private String nameFootballField;
    private String addressFootballField;
    @ManyToOne
    @JoinColumn(name = "idDistrict",referencedColumnName = "idDistrict")
    private District district;
    @ManyToOne
    @JoinColumn(name = "idFootballFieldType",referencedColumnName = "idFootballFieldType")
    private FootballFieldType footballFieldType;
    @ManyToOne
    @JoinColumn(name = "idTimeOfRent",referencedColumnName = "idTimeOfRent")
    private TimeOfRent timeOfRent;


}
