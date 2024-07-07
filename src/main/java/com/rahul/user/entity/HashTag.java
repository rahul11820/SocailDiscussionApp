package com.rahul.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class HashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tag;
}