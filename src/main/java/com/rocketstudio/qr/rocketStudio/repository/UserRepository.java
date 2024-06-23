package com.rocketstudio.qr.rocketStudio.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocketstudio.qr.rocketStudio.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByEmail(String email);
}
