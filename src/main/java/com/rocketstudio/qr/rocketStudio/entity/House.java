package com.rocketstudio.qr.rocketStudio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_house")
    private String id;

    @Column(name = "Number")
    private String number;

    @Column(name = "address")
    private String address;

    @Column(name = "people_amount")
    private Integer peopleAmount;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adminresidentid", referencedColumnName = "id")
    private User adminResident;

    @Column(name = "state")
    private Integer state;
    
}
