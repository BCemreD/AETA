package com.aeta.aeta.controller;

import com.aeta.aeta.business.service.IFavoriteService;
import com.aeta.aeta.model.dto.FavoriteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final IFavoriteService favoriteService;

    @GetMapping
    public List<FavoriteDto> getFavorites() {
        return favoriteService.getFavorites();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FavoriteDto addFavorite(@RequestBody FavoriteDto dto) {
        return favoriteService.addFavorite(dto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeFavorite(@RequestParam Long userId, @RequestParam Long courseId) {
        favoriteService.removeFavorite(userId, courseId);
    }

    @GetMapping("/user/{userId}")
    public List<FavoriteDto> getUserFavorites(@PathVariable Long userId) {
        return favoriteService.getFavoritesByUserId(userId);
    }
}