package com.rocketstudio.qr.rocketStudio.dto;

import java.util.UUID;

import com.rocketstudio.qr.rocketStudio.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {

    private String id;
    private String number;
    private String address;
    private Integer people_amount;
    private String phone;
    private UUID adminresidentid;
    private String state;
}
