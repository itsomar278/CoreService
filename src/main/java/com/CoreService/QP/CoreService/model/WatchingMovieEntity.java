package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "watching_movie", schema = "CoreSchema")
@Getter
@Setter
@EqualsAndHashCode
public class WatchingMovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id", nullable = false)
    private MovieSeasonEntity season;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private MovieEntity movie;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "starting_date", nullable = false)
    private Timestamp startingDate;

    public WatchingMovieEntity() {
    }
    public WatchingMovieEntity(MovieSeasonEntity season, MovieEntity movie, int userId, Timestamp startingDate) {
        this.season = season;
        this.movie = movie;
        this.userId = userId;
        this.startingDate = startingDate;
    }
}