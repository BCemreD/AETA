package com.aeta.aeta.model.entity.career_path;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CareerPathCourseId implements Serializable {
    private Long careerPathId;
    private Long courseId;
}
