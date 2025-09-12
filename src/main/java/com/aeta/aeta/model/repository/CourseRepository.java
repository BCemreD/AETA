package com.aeta.aeta.model.repository;

import com.aeta.aeta.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


    List<Course> findByTagsId(Long tagId);
    List<Course> findByCategoriesId(Long categoryId);
    List<Course> findByTagsIdIn(List<Long> tagIds);
    List<Course> findByCategoriesIdIn(List<Long> categoryIds);
    List<Course> findByTitleContainingIgnoreCase(String title);
    List<Course> findByTitleContainingIgnoreCaseAndTagsIdIn(String title, List<Long> tagIds);
    List<Course> findByTitleContainingIgnoreCaseAndCategoriesIdIn(String title, List<Long> categoryIds);

    // To solve N +1 probs by using JPQL
    @Query("SELECT c FROM Course c JOIN FETCH c.tags")
    List<Course> findAllWithTags();
}