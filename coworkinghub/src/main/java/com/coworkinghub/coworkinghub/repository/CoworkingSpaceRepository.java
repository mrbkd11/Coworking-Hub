package com.coworkinghub.coworkinghub.repository;

import com.coworkinghub.coworkinghub.model.CoworkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoworkingSpaceRepository extends JpaRepository<CoworkingSpace, Long> {
    // Custom query methods can be added here if needed
    // Example: List<CoworkingSpace> findByNameContaining(String name);
}