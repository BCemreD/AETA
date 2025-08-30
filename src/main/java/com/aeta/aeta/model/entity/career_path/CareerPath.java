package com.aeta.aeta.model.entity.career_path;

import com.aeta.aeta.model.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
    @Table(name = "career_paths")
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public class CareerPath extends BaseEntity {

        private String name;
        private String description;

        @OneToMany(mappedBy = "careerPath", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<CareerPathCourse> careerPathCourses = new ArrayList<>();
    }

