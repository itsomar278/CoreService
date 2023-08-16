package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "movie_season")
@Getter
@Setter
@EqualsAndHashCode
public class MovieSeason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 80)
    private String name;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @Column(name = "season_no", nullable = false)
    private Integer seasonNo;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "publish_date", nullable = false)
    private Date publishDate;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    public MovieSeason() {
    }

    public MovieSeason(String name, Movie movie, Integer seasonNo, String url, Date publishDate) {
        this.name = name;
        this.movie = movie;
        this.seasonNo = seasonNo;
        this.url = url;
        this.publishDate = publishDate;
    }
}