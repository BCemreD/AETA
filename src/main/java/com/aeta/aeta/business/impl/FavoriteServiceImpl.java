package com.aeta.aeta.business.impl;

import com.aeta.aeta.business.service.IFavoriteService;
import com.aeta.aeta.model.dto.CourseDto;
import com.aeta.aeta.model.dto.FavoriteDto;
import com.aeta.aeta.model.dto.auth.UserDto;
import com.aeta.aeta.model.entity.Course;
import com.aeta.aeta.model.entity.Favorite;
import com.aeta.aeta.model.entity.User;
import com.aeta.aeta.model.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements IFavoriteService {
    private final FavoriteRepository favoriteRepository;
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }
    @Override
    public List<FavoriteDto> getFavorites() {
        return favoriteRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    private FavoriteDto toDto(Favorite favorite) {
        return FavoriteDto.builder()
                .id(favorite.getId())
                .course(toCourseDto(favorite.getCourse()))
                .user(toUserDto(favorite.getUser()))
                .build();
    }

    private CourseDto toCourseDto(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .build();
    }

    private UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
