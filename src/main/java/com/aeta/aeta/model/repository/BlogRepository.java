package com.aeta.aeta.model.repository;

import com.aeta.aeta.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByTagsId(Long tagId);
    List<Blog> findByCategoriesId(Long categoryId);
    List<Blog> findByTagsIdIn(List<Long> tagIds);
    List<Blog> findByCategoriesIdIn(List<Long> categoryIds);
    List<Blog> findByTitleContainingIgnoreCase(String title);
    List<Blog> findByTitleContainingIgnoreCaseAndTagsIdIn(String title, List<Long> tagIds);
    List<Blog> findByTitleContainingIgnoreCaseAndCategoriesIdIn(String title, List<Long> categoryIds);

    // JPQL n+1
    @Query("SELECT b FROM Blog b JOIN FETCH b.tags")
    List<Blog> findAllWithTags();
}