package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "series")
@Getter
@Setter
@EqualsAndHashCode
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeriesSeason> seasons;

    public Series() {
    }

    public Series(Category category, String name, String description, List<SeriesSeason> seasons) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.seasons = seasons;
    }

    public Series(Category category, String name, String description) {
        this.category = category;
        this.name = name;
        this.description = description;
    }
}