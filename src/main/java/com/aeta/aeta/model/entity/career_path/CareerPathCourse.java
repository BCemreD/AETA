package com.aeta.aeta.model.entity.career_path;


import com.aeta.aeta.model.entity.Course;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "career_path_courses")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CareerPathCourse {

    @EmbeddedId
    private CareerPathCourseId id;

    @ManyToOne
    @MapsId("careerPathId")
    @JoinColumn(name = "career_path_id")
    private CareerPath careerPath;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "order_no")
    private int orderNo;
}
