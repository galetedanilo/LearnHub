package com.galete.learnhub.api.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200)
    private String publicPlace;

    @Column(length = 8)
    private String number;

    @Column(length = 50)
    private String complement;

    @Column(length = 50)
    private String neighborhood;

    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String state;

    @Column(length = 100)
    private String country;

    @Column(length = 10)
    private String zipCode;
}
