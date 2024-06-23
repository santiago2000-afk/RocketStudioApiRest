package com.rocketstudio.qr.rocketStudio.repository;

import com.rocketstudio.qr.rocketStudio.entity.Role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findAll();
}
