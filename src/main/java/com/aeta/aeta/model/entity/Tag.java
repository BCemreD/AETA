package com.aeta.aeta.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "tags")
@NoArgsConstructor
@AllArgsConstructor
@Builder
    public class Tag {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true)
        private String name;
    }

