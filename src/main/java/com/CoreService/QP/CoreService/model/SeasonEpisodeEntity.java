package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "season_episode")
@Getter
@Setter
@EqualsAndHashCode
public class SeasonEpisodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 80)
    private String name;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id", nullable = false)
    private SeriesSeasonEntity season;

    @Column(name = "episode_no", nullable = false)
    private int episodeNo;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "publish_date", nullable = false)
    private Timestamp publishDate;

    public SeasonEpisodeEntity() {
    }

    public SeasonEpisodeEntity(String name, SeriesSeasonEntity season, int episodeNo, String url, Timestamp publishDate) {
        this.name = name;
        this.season = season;
        this.episodeNo = episodeNo;
        this.url = url;
        this.publishDate = publishDate;
    }
}