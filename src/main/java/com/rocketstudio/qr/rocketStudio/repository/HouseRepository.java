package com.rocketstudio.qr.rocketStudio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocketstudio.qr.rocketStudio.entity.House;

@Repository
public interface HouseRepository extends JpaRepository<House, String> {

}