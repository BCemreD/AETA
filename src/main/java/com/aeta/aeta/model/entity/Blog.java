package com.aeta.aeta.model.entity;

import com.aeta.aeta.model.entity.base.BaseContentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table (name = "blogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Blog extends BaseContentEntity {

    @Column(name = "image_src")
    private String imageSrc;

    @Column(name = "image_alt")
    private String imageAlt;

    @Column(name = "url")
    private String url;

    @ManyToMany
    @JoinTable(
            name = "blog_tags",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();
}
