package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "favorite_movie")
@Getter
@Setter
@EqualsAndHashCode
public class FavoriteMovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private MovieEntity movie;

    @Column(name = "user_id", nullable = false)
    private int userId;

    public FavoriteMovieEntity(MovieEntity movie, int userId) {
        this.movie = movie;
        this.userId = userId;
    }

    public FavoriteMovieEntity() {

    }

}