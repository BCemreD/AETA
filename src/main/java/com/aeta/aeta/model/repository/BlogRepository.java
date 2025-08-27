package com.aeta.aeta.model.repository;

import com.aeta.aeta.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface BlogRepository extends JpaRepository<Blog, Long> {
        List<Blog> findByTags_Name(String tagName);
    }


