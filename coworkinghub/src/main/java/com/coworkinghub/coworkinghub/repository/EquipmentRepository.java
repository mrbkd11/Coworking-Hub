package com.coworkinghub.coworkinghub.repository;

import com.coworkinghub.coworkinghub.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    // Custom query methods can be added here
    // Example: List<Equipment> findByTypeOfEquipment(EquipmentType type);
}
