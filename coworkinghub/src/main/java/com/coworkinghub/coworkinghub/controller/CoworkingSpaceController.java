package com.coworkinghub.coworkinghub.controller;

import com.coworkinghub.coworkinghub.model.CoworkingSpace;
import com.coworkinghub.coworkinghub.service.CoworkingSpaceService;
import com.coworkinghub.coworkinghub.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coworking-spaces")
public class CoworkingSpaceController {

    @Autowired
    private CoworkingSpaceService coworkingSpaceService;

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/")
    public ResponseEntity<CoworkingSpace> createCoworkingSpace(@RequestBody CoworkingSpace coworkingSpace) {
        CoworkingSpace newSpace = coworkingSpaceService.createCoworkingSpace(coworkingSpace);
        return ResponseEntity.ok(newSpace);
    }

    // Other endpoints...

    @PostMapping("/{id}/add-random-equipment")
    public ResponseEntity<?> addRandomEquipment(@PathVariable Long id) {
        CoworkingSpace space = coworkingSpaceService.findById(id)
                .orElseThrow(() -> new RuntimeException("Coworking Space not found"));

        equipmentService.addRandomEquipmentToCoworkingSpace(space);
        return ResponseEntity.ok("Random equipment added successfully to the coworking space with ID: " + id);
    }
}