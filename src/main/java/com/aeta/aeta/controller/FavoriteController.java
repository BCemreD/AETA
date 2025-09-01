package com.aeta.aeta.controller;
import com.aeta.aeta.business.service.IFavoriteService;
import com.aeta.aeta.model.dto.FavoriteDto;
import lombok.RequiredArgsConstructor;
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
}
