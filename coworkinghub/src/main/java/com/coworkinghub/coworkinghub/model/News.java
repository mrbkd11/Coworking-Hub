package com.coworkinghub.coworkinghub.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte[] images;
    private String title;
    private Date date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "submitted_by_id")
    private Compte submittedBy;

    // Getters, Setters, Constructors
}
