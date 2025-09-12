package com.aeta.aeta.model.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    private String query;
    private List<Long> tagIds;
    private List<Long> categoryIds;
}
