package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Movie" )
@Getter
@Setter
@EqualsAndHashCode
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieSeasonEntity> seasons;

    public MovieEntity(CategoryEntity category, String name, String description) {
        this.category = category;
        this.name = name;
        this.description = description;
    }

    public MovieEntity(CategoryEntity category, String name, String description, List<MovieSeasonEntity> seasons) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.seasons = seasons;
    }

    public MovieEntity(){

    }

}