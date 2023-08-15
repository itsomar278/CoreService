package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "watching_movie")
@Getter
@Setter
@EqualsAndHashCode
public class WatchingMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id", nullable = false)
    private MovieSeason season;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "starting_date", nullable = false)
    private Date startingDate;

    public WatchingMovie() {
    }
    public WatchingMovie(MovieSeason season, Movie movie, Integer userId, Date startingDate) {
        this.season = season;
        this.movie = movie;
        this.userId = userId;
        this.startingDate = startingDate;
    }
}