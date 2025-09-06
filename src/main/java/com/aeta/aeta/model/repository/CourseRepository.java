package com.aeta.aeta.model.repository;

import com.aeta.aeta.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c JOIN FETCH c.tags")
    List<Course> findAllWithTags();

    List<Course> findByTagsId(Long tagId);
}