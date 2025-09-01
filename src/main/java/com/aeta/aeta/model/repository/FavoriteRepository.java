package com.aeta.aeta.model.repository;

import com.aeta.aeta.model.dto.FavoriteDto;
import com.aeta.aeta.model.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite,Long> {

    List<Favorite> findByUserId(Long userId);
    List<Favorite> findByCourseId(Long courseId);
}
