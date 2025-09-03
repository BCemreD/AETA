package com.aeta.aeta.business.service;

import com.aeta.aeta.model.dto.FavoriteDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IFavoriteService {
    List<FavoriteDto> getFavorites();
    FavoriteDto addFavorite(FavoriteDto favoriteDto);
    void removeFavorite(Long userId, Long courseId);
    List<FavoriteDto> getFavoritesByUserId(@PathVariable Long id);
}
