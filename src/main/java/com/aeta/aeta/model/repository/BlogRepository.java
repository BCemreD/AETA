package com.aeta.aeta.model.repository;

import com.aeta.aeta.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query("SELECT b FROM Blog b JOIN FETCH b.tags")
    List<Blog> findAllWithTags();

    @Query("SELECT b FROM Blog b JOIN FETCH b.tags t WHERE t.id = :tagId")
    List<Blog> findByTagsIdWithTags(@Param("tagId") Long tagId);

    List<Blog> findByCategoriesId(@Param("categoryId") Long categoryId);
}

