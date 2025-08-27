package com.aeta.aeta.model.repository;


import com.aeta.aeta.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface CourseRepository extends JpaRepository<Course, Long> {
        List<Course> findByTags_Name(String tagName);
    }


