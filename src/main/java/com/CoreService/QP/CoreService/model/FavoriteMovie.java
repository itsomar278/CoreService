package com.CoreService.QP.CoreService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "favorite_movie")
@Getter
@Setter
@EqualsAndHashCode
public class FavoriteMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    public FavoriteMovie(Movie movie, Integer userId) {
        this.movie = movie;
        this.userId = userId;
    }

    public FavoriteMovie() {

    }

}