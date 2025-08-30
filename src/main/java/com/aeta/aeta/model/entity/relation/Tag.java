package com.aeta.aeta.model.entity.relation;

import com.aeta.aeta.model.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "tags")
@NoArgsConstructor
@AllArgsConstructor
@Builder
    public class Tag extends BaseEntity {

        @Column(unique = true)
        private String name;
    }

