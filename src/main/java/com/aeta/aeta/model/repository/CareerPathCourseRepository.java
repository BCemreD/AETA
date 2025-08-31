package com.aeta.aeta.model.repository;

import com.aeta.aeta.model.entity.career_path.CareerPathCourse;
import com.aeta.aeta.model.entity.career_path.CareerPathCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerPathCourseRepository extends JpaRepository<CareerPathCourse, CareerPathCourseId> {
    List<CareerPathCourse> findByCareerPath_IdOrderByOrderNoAsc(Long careerPathId);

}
