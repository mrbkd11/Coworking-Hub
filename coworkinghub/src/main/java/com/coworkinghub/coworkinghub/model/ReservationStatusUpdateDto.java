package com.coworkinghub.coworkinghub.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationStatusUpdateDto {
    @Enumerated(EnumType.ORDINAL)

    private ReservationStatus status;
    private String reason;

    // Getters and setters...

    // Constructor...
}
