package com.aeta.aeta.model.entity.relation;

import com.aeta.aeta.model.entity.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table (name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity {

    @NotBlank
    private String name;


}
