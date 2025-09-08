package com.aeta.aeta.model.repository;

import com.aeta.aeta.model.entity.relation.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long> {

    List<Tag> findAll();
    List<Tag> findByNameContainingIgnoreCase(String name);
}
