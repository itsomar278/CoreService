package com.CoreService.QP.CoreService.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "watching_episode", schema = "CoreSchema")
@Getter
@Setter
@EqualsAndHashCode
public class WatchingEpisodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "series_id", referencedColumnName = "id", nullable = false)
    private SeriesEntity series;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id", nullable = false)
    private SeriesSeasonEntity season;

    @ManyToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "id", nullable = false)
    private SeasonEpisodeEntity episode;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "starting_date", nullable = false)
    private Timestamp startingDate;

    public WatchingEpisodeEntity(SeriesEntity series, SeriesSeasonEntity season, SeasonEpisodeEntity episode, int userId, Timestamp startingDate) {
        this.series = series;
        this.season = season;
        this.episode = episode;
        this.userId = userId;
        this.startingDate = startingDate;
    }

    public WatchingEpisodeEntity() {
    }
}
