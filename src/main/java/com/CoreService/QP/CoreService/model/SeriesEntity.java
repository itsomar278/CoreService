package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "series")
@Getter
@Setter
@EqualsAndHashCode
public class SeriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeriesSeasonEntity> seasons;

    public SeriesEntity() {
    }

    public SeriesEntity(CategoryEntity category, String name, String description, List<SeriesSeasonEntity> seasons) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.seasons = seasons;
    }

    public SeriesEntity(CategoryEntity category, String name, String description) {
        this.category = category;
        this.name = name;
        this.description = description;
    }
}