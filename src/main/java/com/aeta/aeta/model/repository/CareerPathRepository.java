package com.aeta.aeta.model.repository;

import com.aeta.aeta.model.entity.career_path.CareerPath;
import com.aeta.aeta.model.entity.career_path.CareerPathCourse;
import com.aeta.aeta.model.entity.career_path.CareerPathCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerPathRepository extends JpaRepository<CareerPath, Long> {
}

public interface CareerPathCourseRepository extends JpaRepository<CareerPathCourse, CareerPathCourseId> {
    List<CareerPathCourse> findByCareerPathIdOrderByOrderNoAsc(Long careerPathId);
}
