package com.CoreService.QP.CoreService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "watching_episode")
@Getter
@Setter
@EqualsAndHashCode
public class WatchingEpisode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "series_id", referencedColumnName = "id", nullable = false)
    private Series series;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id", nullable = false)
    private SeriesSeason season;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "id", nullable = false)
    private SeasonEpisode episode;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "starting_date", nullable = false)
    private Date startingDate;

    public WatchingEpisode(Series series, SeriesSeason season, SeasonEpisode episode, Integer userId, Date startingDate) {
        this.series = series;
        this.season = season;
        this.episode = episode;
        this.userId = userId;
        this.startingDate = startingDate;
    }

    public WatchingEpisode() {
    }
}
