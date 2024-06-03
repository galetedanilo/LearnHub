package com.galete.learnhub.api.user.entity;

import jakarta.persistence.*;

import lombok.*;


@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 15)
    private String phone;

    @Column(length = 15)
    private String cellPhone;

    @Column(length = 100)
    private String linkedin;

    @Column(length = 100)
    private String webSite;
}
