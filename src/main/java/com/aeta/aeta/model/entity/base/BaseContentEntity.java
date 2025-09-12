package com.aeta.aeta.model.entity.base;

import com.aeta.aeta.model.entity.relation.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseContentEntity extends BaseEntity{

    private String title;

}
