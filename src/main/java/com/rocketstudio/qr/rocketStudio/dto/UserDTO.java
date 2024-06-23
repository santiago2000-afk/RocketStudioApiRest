package com.rocketstudio.qr.rocketStudio.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private UUID id;
    private String name;
    private String lastname;
    private String dui;
    private String houseId;
    private String phone;
    private Integer roleId;
    private String googleUser;
    private String email;
    private String password;
    private Integer state;

    public UserDTO(UUID id, String name, String lastname, String dui, String houseId, String phone, Integer roleId,
            String googleUser, String email, String password, Integer state) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dui = dui;
        this.houseId = houseId;
        this.phone = phone;
        this.roleId = roleId;
        this.googleUser = googleUser;
        this.email = email;
        this.password = password;
        this.state = state;
    }
}
