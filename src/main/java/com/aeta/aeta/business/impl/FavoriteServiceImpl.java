package com.aeta.aeta.business.impl;

import com.aeta.aeta.business.service.IFavoriteService;
import com.aeta.aeta.model.dto.CourseDto;
import com.aeta.aeta.model.dto.FavoriteDto;
import com.aeta.aeta.model.dto.auth.UserDto;
import com.aeta.aeta.model.entity.Course;
import com.aeta.aeta.model.entity.Favorite;
import com.aeta.aeta.model.entity.User;
import com.aeta.aeta.model.repository.CourseRepository;
import com.aeta.aeta.model.repository.FavoriteRepository;
import com.aeta.aeta.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements IFavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<FavoriteDto> getFavorites() {
        return favoriteRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FavoriteDto addFavorite(FavoriteDto favoriteDto) {
        User user = userRepository.findById(favoriteDto.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Course course = courseRepository.findById(favoriteDto.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Favorite favorite = Favorite.builder()
                .user(user)
                .course(course)
                .build();

        favorite = favoriteRepository.save(favorite);
        return toDto(favorite);
    }

    @Override
    public void removeFavorite(Long userId, Long courseId) {
        favoriteRepository.deleteByUserIdAndCourseId(userId, courseId);
    }

    @Override
    public List<FavoriteDto> getFavoritesByUserId(Long id) {
        return favoriteRepository.findByUserId(id)
                .stream()
                .map(this::toDto)
                .toList();
    }

    private FavoriteDto toDto(Favorite favorite) {
        return FavoriteDto.builder()
                .id(favorite.getId())
                .course(CourseDto.builder()
                        .id(favorite.getCourse().getId())
                        .title(favorite.getCourse().getTitle())
                        .build())
                .user(UserDto.builder()
                        .id(favorite.getUser().getId())
                        .firstName(favorite.getUser().getFirstName())
                        .lastName(favorite.getUser().getLastName())
                        .build())
                .build();
    }

    private CourseDto toCourseDto(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .imageSrc(course.getImageSrc())
                .imageAlt(course.getImageAlt())
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