package com.aeta.aeta.model.dto;

import lombok.*;

import java.util.Set;

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
    private Set<String> tags;
    private Set<String> categories;

}
