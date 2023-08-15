package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "season_episode")
@Getter
@Setter
@EqualsAndHashCode
public class SeasonEpisode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 80)
    private String name;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id", nullable = false)
    private SeriesSeason season;

    @Column(name = "episode_no", nullable = false)
    private Integer episodeNo;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "publish_date", nullable = false)
    private Date publishDate;

    public SeasonEpisode() {
    }

    public SeasonEpisode(String name, SeriesSeason season, Integer episodeNo, String url, Date publishDate) {
        this.name = name;
        this.season = season;
        this.episodeNo = episodeNo;
        this.url = url;
        this.publishDate = publishDate;
    }
}