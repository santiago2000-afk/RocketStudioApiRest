package com.rocketstudio.qr.rocketStudio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginRequest {

    private String email;
    private String password;
    public String getEmail() {
        return email;
    }
}