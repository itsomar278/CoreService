package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "movie" )
@Getter
@Setter
@EqualsAndHashCode
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieSeason> seasons;

    public Movie(Category category, String name, String description) {
        this.category = category;
        this.name = name;
        this.description = description;
    }

    public Movie(Category category, String name, String description, List<MovieSeason> seasons) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.seasons = seasons;
    }

    public Movie(){

    }

}