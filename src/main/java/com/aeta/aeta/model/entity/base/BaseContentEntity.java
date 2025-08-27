package com.aeta.aeta.model.entity.base;

import com.aeta.aeta.model.entity.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseContentEntity extends BaseEntity{

    private String title;

    @ManyToMany
    @JoinTable (
            name = "content_categories",
            joinColumns = @JoinColumn (name = "content_id"),
            inverseJoinColumns = @JoinColumn (name = "category_id")
    )
    private Set<Category> categories;
}
