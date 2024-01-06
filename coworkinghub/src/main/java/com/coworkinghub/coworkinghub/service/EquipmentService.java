package com.coworkinghub.coworkinghub.service;

import com.coworkinghub.coworkinghub.model.CoworkingSpace;
import com.coworkinghub.coworkinghub.model.Equipment;
import com.coworkinghub.coworkinghub.model.EquipmentType;
import com.coworkinghub.coworkinghub.repository.EquipmentRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Autowired // This annotation is optional in newer versions of Spring
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public void addRandomEquipmentToCoworkingSpace(CoworkingSpace coworkingSpace) {
        List<Equipment> equipments = new ArrayList<>();
        for (EquipmentType type : EquipmentType.values()) {
            Equipment equipment = new Equipment();
            equipment.setName(type.name() + " " + RandomStringUtils.randomAlphabetic(5));
            equipment.setPrice(Math.random() * 100); // Random price
            equipment.setTypeOfEquipment(type);
            equipment.setCoworkingSpace(coworkingSpace);
            equipments.add(equipment);
        }
        equipmentRepository.saveAll(equipments);
    }
}
