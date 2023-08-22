package com.CoreService.QP.CoreService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @Column(name = "description")
    private String description;

    @Transient
    private Long count ;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<MovieSeason> seasons;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieCategory> categories;

    public Movie( String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Movie(String name, String description, List<MovieSeason> seasons) {
        this.name = name;
        this.description = description;
        this.seasons = seasons;
    }

    public Movie(Long count , Movie movie){
        this.id = movie.getId();
        this.name = movie.getName();
        this.description = movie.getDescription();
        this.count = count;
        this.categories = movie.categories;
        this.seasons = movie.seasons;
    }

    public Movie(){

    }

}