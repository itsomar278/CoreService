package com.CoreService.QP.CoreService.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
    @Table(name = "series_season")
    @Getter
    @Setter
    @EqualsAndHashCode
    public class SeriesSeason {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "name", length = 80)
        private String name;

        @ManyToOne
        @JoinColumn(name = "series_id", referencedColumnName = "id", nullable = false)
        private Series series;

        @Column(name = "season_no", nullable = false)
        private Integer seasonNo;

        @Column(name = "publish_date", nullable = false)
        private Date publishDate;

        @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<SeasonEpisode> episodes ;

    public SeriesSeason() {
    }

    public SeriesSeason(String name, Series series, Integer seasonNo, String url, Date publishDate, List<SeasonEpisode> episodes) {
        this.name = name;
        this.series = series;
        this.seasonNo = seasonNo;
        this.publishDate = publishDate;
        this.episodes = episodes;
    }

    public SeriesSeason(String name, Series series, int seasonNo, String url, Date publishDate) {
        this.name = name;
        this.series = series;
        this.seasonNo = seasonNo;
        this.publishDate = publishDate;
    }

}
