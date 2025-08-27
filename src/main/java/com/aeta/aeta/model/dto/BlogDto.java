package com.aeta.aeta.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogDto {
    private Long id;
    private String title;
    private String imageSrc;
    private String imageAlt;
    private String url;
}
