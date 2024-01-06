package com.coworkinghub.coworkinghub.model;

import jakarta.persistence.*;

@Entity

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int capacity;
    private double pricePerPersonPerHour;

    @ManyToOne
    @JoinColumn(name = "coworking_space_id")
    private CoworkingSpace coworkingSpace;
}



