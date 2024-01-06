package com.coworkinghub.coworkinghub.controller;

import com.coworkinghub.coworkinghub.model.Reservation;
import com.coworkinghub.coworkinghub.model.ReservationDto;
import com.coworkinghub.coworkinghub.model.ReservationStatusUpdateDto;
import com.coworkinghub.coworkinghub.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired

    private ReservationService reservationService;

    @PostMapping("/")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDto reservationDto) {
        Reservation reservation = reservationService.createReservation(reservationDto);
        return ResponseEntity.ok(reservation);
    }


    // Other endpoints...

    @PutMapping("/{id}/status")
    public ResponseEntity<Reservation> updateReservationStatus(@PathVariable Long id,
                                                               @RequestBody ReservationStatusUpdateDto statusUpdateDto) {
        Reservation updatedReservation = reservationService.updateReservationStatus(id,
                statusUpdateDto.getStatus(),
                statusUpdateDto.getReason());
        return ResponseEntity.ok(updatedReservation);
    }

    // Other API endpoints as required...
}