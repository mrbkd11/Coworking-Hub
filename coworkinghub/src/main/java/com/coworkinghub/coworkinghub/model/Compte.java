package com.coworkinghub.coworkinghub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private Integer age;
    private String profession;
    private AccountType typeCompte;

    @OneToMany(mappedBy = "compte")
    private Set<Reservation> reservations;

    // Assuming an admin can submit news
    @OneToMany(mappedBy = "submittedBy")
    private Set<News> newsSubmissions;

    // If owners have their coworking spaces
    @OneToMany(mappedBy = "owner")
    private Set<CoworkingSpace> ownedSpaces;
}

enum AccountType {
    ADMIN, USER, OWNER;
}