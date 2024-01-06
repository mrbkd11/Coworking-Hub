package com.coworkinghub.coworkinghub.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class CoworkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double coordinateX;
    private double coordinateY;
    private String address;
    private byte[] images;
    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    @OneToMany(mappedBy = "coworkingSpace")
    private Set<Room> rooms;

    @OneToMany(mappedBy = "coworkingSpace")
    private Set<Equipment> equipments;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Compte owner;


    // Getters, Setters, Constructors
}