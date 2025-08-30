package com.aeta.aeta.model.entity;

import com.aeta.aeta.model.entity.base.BaseContentEntity;
import com.aeta.aeta.model.entity.relation.Tag;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table (name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course extends BaseContentEntity {

    @Column(name = "image_src")
    private String imageSrc;

    @Column(name = "image_alt")
    private String imageAlt;

    @ManyToMany
    @JoinTable(
            name = "course_tags",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

}
