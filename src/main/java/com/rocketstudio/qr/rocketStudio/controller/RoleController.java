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

import com.rocketstudio.qr.rocketStudio.dto.RoleDTO;
import com.rocketstudio.qr.rocketStudio.entity.Role;
import com.rocketstudio.qr.rocketStudio.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        try {
            List<Role> roles = roleService.getAllRoles();
            logger.info("Número de roles recuperados: {}", roles.size());
            List<RoleDTO> roleDTOs = roles.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(roleDTOs);
        } catch (Exception e) {
            logger.error("Error al obtener roles: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private RoleDTO convertToDTO(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setRoleName(role.getRoleName());
        dto.setDescription(role.getDescription());
        return dto;
    }
}