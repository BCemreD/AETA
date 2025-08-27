package com.aeta.aeta.model.repository;

import com.aeta.aeta.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {
    List<Job> findByTags_Id(Long tagId);
}
