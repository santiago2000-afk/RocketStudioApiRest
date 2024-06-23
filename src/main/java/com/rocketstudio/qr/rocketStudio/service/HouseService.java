package com.rocketstudio.qr.rocketStudio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketstudio.qr.rocketStudio.entity.House;
import com.rocketstudio.qr.rocketStudio.repository.HouseRepository;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }
}

