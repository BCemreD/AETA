package com.aeta.aeta.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {

    private Long id;
    private String title;
    private String imageSrc;
    private String imageAlt;
}
