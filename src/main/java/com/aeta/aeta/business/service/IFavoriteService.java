package com.aeta.aeta.business.service;

import com.aeta.aeta.model.dto.FavoriteDto;

import java.util.List;

public interface IFavoriteService {
    List<FavoriteDto> getFavorites();
}
