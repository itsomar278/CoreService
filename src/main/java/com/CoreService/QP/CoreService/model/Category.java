package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@Getter
@Setter
@EqualsAndHashCode
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type", nullable = false, length = 25)
    private String type;

    public Category(String type)
    {
        this.type = type;
    }

    public Category() {

    }
}
