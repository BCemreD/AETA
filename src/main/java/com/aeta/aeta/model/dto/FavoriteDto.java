package com.aeta.aeta.model.dto;

import com.aeta.aeta.model.dto.auth.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoriteDto {
    private Long id;
    private CourseDto course;
    private UserDto user;
}
