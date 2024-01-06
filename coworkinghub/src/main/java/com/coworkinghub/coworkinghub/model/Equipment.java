package com.coworkinghub.coworkinghub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    @Enumerated(EnumType.ORDINAL)
    private EquipmentType typeOfEquipment;
    @ManyToOne
    @JoinColumn(name = "coworking_space_id")
    private CoworkingSpace coworkingSpace;


    // Getters, Setters, Constructors
}

