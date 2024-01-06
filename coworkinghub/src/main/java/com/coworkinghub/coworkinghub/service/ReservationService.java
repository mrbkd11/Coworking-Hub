package com.coworkinghub.coworkinghub.service;

import com.coworkinghub.coworkinghub.model.*;
import com.coworkinghub.coworkinghub.repository.CoworkingSpaceRepository;
import com.coworkinghub.coworkinghub.repository.EquipmentRepository;
import com.coworkinghub.coworkinghub.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CoworkingSpaceRepository coworkingSpaceRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    // Other required repositories...

    @Transactional
    public Reservation createReservation(ReservationDto reservationDto) {
        // Validate the requested coworking space and equipment availability
        CoworkingSpace space = coworkingSpaceRepository.findById(reservationDto.getCoworkingSpaceId())
                .orElseThrow(() -> new RuntimeException("Coworking space not found"));

        // Check availability logic here...

        // Create a new Reservation
        Reservation reservation = new Reservation();
        reservation.setCoworkingSpace(space);
        reservation.setDate(reservationDto.getDate());
        reservation.setTime(reservationDto.getTime());
        reservation.setHours(reservationDto.getHours());
        reservation.setNumberOfPeople(reservationDto.getNumberOfPeople());
        reservation.setStatus(ReservationStatus.PENDING);

        // Handle equipment reservation
        Set<Equipment> reservedEquipments = new HashSet<>();
        reservationDto.getEquipmentIds().forEach(id -> {
            Equipment equipment = equipmentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Equipment not found"));
            reservedEquipments.add(equipment);

            // Additional logic to check quantity and availability...
        });
        reservation.setReservedEquipments(reservedEquipments);

        // Calculate total price logic here...

        // Save the Reservation
        return reservationRepository.save(reservation);
    }
    public Reservation updateReservationStatus(Long reservationId, ReservationStatus newStatus, String reason) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setStatus(newStatus);
        reservation.setStatusChangeReason(reason);

        return reservationRepository.save(reservation);
    }

    // Other service methods...
}
