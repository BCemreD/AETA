package com.aeta.aeta.model.entity;

import com.aeta.aeta.model.entity.base.BaseContentEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.*;

@Entity
@Table (name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job extends BaseContentEntity {

    @NotBlank
    @Size(min = 50)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "job_tags",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();
}
