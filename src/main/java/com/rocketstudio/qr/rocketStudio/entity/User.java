package com.rocketstudio.qr.rocketStudio.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "dui")
    private String dui;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_house", referencedColumnName = "id_house")
    private House house;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid", referencedColumnName = "id_role")
    private Role role;

    @Column(name = "googleuser")
    private String googleUser;

    @Column(name = "email")
    private String email;

    @Column(name = "psswrd")
    private String password;

    @Column(name = "state")
    private Integer state;
}