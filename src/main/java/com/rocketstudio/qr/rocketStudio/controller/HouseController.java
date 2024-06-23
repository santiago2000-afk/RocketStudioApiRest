package com.rocketstudio.qr.rocketStudio.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketstudio.qr.rocketStudio.dto.HouseDTO;
import com.rocketstudio.qr.rocketStudio.entity.House;
import com.rocketstudio.qr.rocketStudio.service.HouseService;

@RestController
@RequestMapping("/api")
public class HouseController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/houses")
    public ResponseEntity<List<HouseDTO>> getAllHouses() {
        try {
            List<House> houses = houseService.getAllHouses();
            logger.info("Número de casas recuperados: {}", houses.size());
            List<HouseDTO> houseDTOs = houses.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(houseDTOs);
        } catch (Exception e) {
            logger.error("Error al obtener casas: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private HouseDTO convertToDTO(House house) {
        HouseDTO dto = new HouseDTO();
        dto.setId(house.getId());
        dto.setNumber(house.getNumber());
        dto.setAddress(house.getAddress());
        dto.setPeople_amount(house.getPeopleAmount());
        dto.setPhone(house.getPhone());

        return dto;
    }
}