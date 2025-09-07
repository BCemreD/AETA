package com.aeta.aeta.model.dto;

import lombok.*;

import java.util.Set;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class CategoryDto {
        private Long id;
        private String name;
        private Set<CategoryDto> subCategories;
    }


