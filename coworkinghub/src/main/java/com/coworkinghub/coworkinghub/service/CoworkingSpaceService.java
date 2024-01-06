package com.coworkinghub.coworkinghub.service;

import com.coworkinghub.coworkinghub.model.CoworkingSpace;
import com.coworkinghub.coworkinghub.repository.CoworkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoworkingSpaceService {

    @Autowired
    private CoworkingSpaceRepository coworkingSpaceRepository;

    @Autowired // This annotation is optional in newer versions of Spring
    public CoworkingSpaceService(CoworkingSpaceRepository coworkingSpaceRepository) {
        this.coworkingSpaceRepository = coworkingSpaceRepository;
    }


    public CoworkingSpace createCoworkingSpace(CoworkingSpace coworkingSpace) {
        // Business logic here, if necessary
        return coworkingSpaceRepository.save(coworkingSpace);
    }



    public Optional<CoworkingSpace> findById(Long id) {
        return coworkingSpaceRepository.findById(id);
    }

    // Other business methods like create, update, delete...
}