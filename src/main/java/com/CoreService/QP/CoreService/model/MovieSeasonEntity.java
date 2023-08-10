package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "movie_season", schema = "CoreSchema")
@Getter
@Setter
@EqualsAndHashCode
public class MovieSeasonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 80)
    private String name;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private MovieEntity movie;

    @Column(name = "season_no", nullable = false)
    private int seasonNo;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "publish_date", nullable = false)
    private Timestamp publishDate;

    public MovieSeasonEntity() {
    }

    public MovieSeasonEntity(String name, MovieEntity movie, int seasonNo, String url, Timestamp publishDate) {
        this.name = name;
        this.movie = movie;
        this.seasonNo = seasonNo;
        this.url = url;
        this.publishDate = publishDate;
    }
}