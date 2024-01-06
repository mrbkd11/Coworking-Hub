package com.coworkinghub.coworkinghub.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Date date;
    private String time;
    private Integer hours;
    private Integer numberOfPeople;
    private Long coworkingSpaceId;
    private Set<Long> equipmentIds;



    // Getters, Setters, Constructors
}

