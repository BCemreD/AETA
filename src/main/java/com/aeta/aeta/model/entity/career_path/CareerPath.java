package com.aeta.aeta.model.entity.career_path;

import com.aeta.aeta.model.entity.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
    @Table(name = "career_paths")
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public class CareerPath extends BaseEntity {

        @NotBlank
        private String name;
        @NotBlank
        @Size(min = 3, max = 500)
        private String description;

        @OneToMany(mappedBy = "careerPath", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<CareerPathCourse> careerPathCourses = new ArrayList<>();
    }

