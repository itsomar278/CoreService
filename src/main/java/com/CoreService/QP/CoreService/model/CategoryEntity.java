package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(schema = "CoreSchema" , name = "Category")
@Getter
@Setter
@EqualsAndHashCode
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Type", nullable = false, length = 25)
    private String type;

    public CategoryEntity (String type)
    {
        this.type = type;
    }

    public CategoryEntity() {

    }
}
