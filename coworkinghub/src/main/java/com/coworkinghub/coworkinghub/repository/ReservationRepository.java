package com.coworkinghub.coworkinghub.repository;

import com.coworkinghub.coworkinghub.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCompteId(Long compteId);
    List<Reservation> findByDateBetween(Date startDate, Date endDate);

    // List<Reservation> findByCoworkingSpaceId(Long coworkingSpaceId);
}