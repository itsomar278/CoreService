package com.CoreService.QP.CoreService.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.NotNull;
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

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;


    public Category(String type)
    {
        this.type = type;
    }

    public Category() {

    }
}
